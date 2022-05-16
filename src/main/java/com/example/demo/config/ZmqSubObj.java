package com.example.demo.config;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class ZmqSubObj {

    private final ZContext context;
    private final ZMQ.Socket socket;

    public ZmqSubObj(ZContext context) {
        this.context = context;
        this.socket = context.createSocket(SocketType.SUB);
    }

    public ZMQ.Socket getSocket() {
        return socket;
    }

    @PostConstruct
    public void init() {
        this.socket.bind("tcp://127.0.0.1:5557");
        this.socket.subscribe("robot-status");
    }

    @PreDestroy
    public void destroy() {
        this.socket.close();
    }

}
