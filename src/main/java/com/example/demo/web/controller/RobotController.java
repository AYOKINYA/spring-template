package com.example.demo.web.controller;

import com.example.demo.config.ZmqObj;
import com.example.demo.error.exception.DemoException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zeromq.ZMQ;


@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RobotController {

    private final ZmqObj zmqObj;

    private void sendMessageToZmq(String msg) {
        zmqObj.getSocket().send("control-robot".getBytes(ZMQ.CHARSET), ZMQ.SNDMORE);
        zmqObj.getSocket().send(msg);
    }

    @GetMapping("/basic/estop")
    public ResponseEntity eStop() {
        String msg = "estop";
        sendMessageToZmq(msg);
        return new ResponseEntity(msg , HttpStatus.OK);
    }

    @GetMapping("/basic/power")
    public ResponseEntity powerOnOff() {
        String msg = "Power";
        sendMessageToZmq(msg);
        return new ResponseEntity(msg , HttpStatus.OK);
    }

    @GetMapping("/behavior/dock")
    public ResponseEntity dock() {
        String msg = "dock";
        sendMessageToZmq(msg);
        return new ResponseEntity(msg , HttpStatus.OK);
    }

    @GetMapping("/behavior/undock")
    public ResponseEntity undock() {
        String msg = "undock";
        sendMessageToZmq(msg);
        return new ResponseEntity(msg , HttpStatus.OK);
    }

    @GetMapping("/behavior/forward")
    public ResponseEntity forward() {
        String msg = "forward";
        sendMessageToZmq(msg);
        return new ResponseEntity(msg , HttpStatus.OK);
    }

    @GetMapping("/behavior/backward")
    public ResponseEntity backward() {
        String msg = "backward";
        sendMessageToZmq(msg);
        return new ResponseEntity(msg , HttpStatus.OK);
    }

    @GetMapping("/behavior/left")
    public ResponseEntity goLeft() {
        String msg = "left";
        sendMessageToZmq(msg);
        return new ResponseEntity(msg , HttpStatus.OK);
    }

    @GetMapping("/behavior/right")
    public ResponseEntity goRight() {
        String msg = "right";
        sendMessageToZmq(msg);
        return new ResponseEntity(msg , HttpStatus.OK);
    }
    @GetMapping("/behavior/rotate/left")
    public ResponseEntity rotateLeft() {
        String msg = "rotate-left";
        sendMessageToZmq(msg);
        return new ResponseEntity(msg , HttpStatus.OK);
    }
    @GetMapping("/behavior/rotate/right")
    public ResponseEntity rotateRight() {
        String msg = "rotate-right";
        sendMessageToZmq(msg);
        return new ResponseEntity(msg , HttpStatus.OK);
    }
    @GetMapping("/behavior/stand")
    public ResponseEntity stand() {
        String msg = "stand";
        sendMessageToZmq(msg);
        return new ResponseEntity(msg , HttpStatus.OK);
    }
    @GetMapping("/behavior/sit")
    public ResponseEntity sit() {
        String msg = "sit";
        sendMessageToZmq(msg);
        return new ResponseEntity(msg , HttpStatus.OK);
    }
    @GetMapping("/behavior/self")
    public ResponseEntity self() {
        String msg = "self";
        sendMessageToZmq(msg);
        return new ResponseEntity(msg , HttpStatus.OK);
    }

}
