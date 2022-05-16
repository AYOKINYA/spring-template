package com.example.demo.websocket;

import com.example.demo.config.ZmqSubObj;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.zeromq.ZMQ;

import java.util.concurrent.ConcurrentHashMap;
import java.nio.charset.StandardCharsets;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.Gson;


@Component
@RequiredArgsConstructor
public class SocketHandler extends TextWebSocketHandler {

    @Autowired
    private final ZmqSubObj zmqSubObj;

    ConcurrentHashMap<String, WebSocketSession> sessionMap = new ConcurrentHashMap<>();

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        String msg = message.getPayload();
        System.out.println(session.toString());
        System.out.println(message);
        for (String key : sessionMap.keySet()) {
            WebSocketSession wss = sessionMap.get(key);
            try {
                wss.sendMessage(new TextMessage(msg));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        sessionMap.put(session.getId(), session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessionMap.remove(session.getId());
        super.afterConnectionClosed(session, status);
    }

    @Scheduled(cron = "0/1 * * * * *")
    private void readMQ() {
        System.out.println("every one second");

        try {
            byte[] topic = zmqSubObj.getSocket().recv(ZMQ.NOBLOCK);
            byte[] data = zmqSubObj.getSocket().recv(ZMQ.NOBLOCK);
            if (data != null) {
                String str = new String(data, StandardCharsets.UTF_8);
                System.out.println(
                        "Received2: " + str
                );
                try{

                    GsonBuilder builder = new GsonBuilder();
                    builder.setPrettyPrinting();
                    Gson gson = builder.create();
                    Status status = gson.fromJson(str, Status.class);

                    System.out.println(status.ShowAsString());

                    str = gson.toJson(status);
                    System.out.println("User Object as string : "+str);

                }catch(JsonIOException err){
                    System.out.println("Exception : "+err.toString());
                }
            }


        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}

class Status {
    public int power;
    public int battery;
    public int run_time;
    public int estop;
    public String ShowAsString() {
        return "User ["+power+", "+ battery+ ", " +run_time+ "]";
    }
}