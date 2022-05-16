package com.example.demo.config;
import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class ZmqPubObj {

    private final ZContext context;
    private final ZMQ.Socket socket;

    public ZmqPubObj(ZContext context) {
        this.context = context;
        this.socket = context.createSocket(SocketType.PUB);
    }

    public ZMQ.Socket getSocket() {
        return socket;
    }

    @PostConstruct
    public void init() {
        this.socket.bind("tcp://127.0.0.1:5556");
    }

    @PreDestroy
    public void destroy() {
        this.socket.close();
    }


}
