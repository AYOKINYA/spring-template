package com.example.demo.config;
import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class ZmqObj {

    private final ZContext context;
    private final ZMQ.Socket socket;

    public ZmqObj(ZContext context) {
        this.context = context;
        this.socket = context.createSocket(SocketType.PUB);
        socket.bind("tcp://*:5556");
    }

    public ZMQ.Socket getSocket() {
        return socket;
    }


}
