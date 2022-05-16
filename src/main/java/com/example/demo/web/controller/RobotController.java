package com.example.demo.web.controller;

import com.example.demo.config.ZmqPubObj;
import com.example.demo.error.exception.RobotException;
import com.example.demo.web.dto.robot.JoystickAxes;
import com.example.demo.web.dto.robot.JoystickAxesStandMode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zeromq.ZMQ;


@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RobotController {

    private final ZmqPubObj zmqPubObj;

    private synchronized void sendMessageToZmq(String msg) {
        try {
            zmqPubObj.getSocket().send("control-robot".getBytes(ZMQ.CHARSET), ZMQ.SNDMORE);
            zmqPubObj.getSocket().send(msg);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/basic/estop")
    public ResponseEntity<String> eStop() {
        String msg = "estop";
        System.out.println(msg);
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg , HttpStatus.OK);
    }

    @GetMapping("/basic/power")
    public ResponseEntity<String> powerOnOff() {
        String msg = "Power";
        System.out.println(msg);
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg , HttpStatus.OK);
    }

    @GetMapping("/behavior/dock")
    public ResponseEntity<String> dock() {
        String msg = "dock";
        System.out.println(msg);
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg , HttpStatus.OK);
    }

    @GetMapping("/behavior/undock")
    public ResponseEntity<String> undock() {
        String msg = "undock";
        System.out.println(msg);
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg , HttpStatus.OK);
    }

    @GetMapping("/behavior/forward")
    public ResponseEntity<String> forward() {
        String msg = "forward";
        System.out.println(msg);
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg , HttpStatus.OK);
    }

    @GetMapping("/behavior/forward/rotate/left")
    public ResponseEntity<String> forwardRotateLeft() {
        String msg = "forward-rotate-left";
        System.out.println(msg);
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg , HttpStatus.OK);
    }

    @GetMapping("/behavior/forward/rotate/right")
    public ResponseEntity<String> forwardRotateRight() {
        String msg = "forward-rotate-right";
        System.out.println(msg);
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg , HttpStatus.OK);
    }

    @GetMapping("/behavior/backward")
    public ResponseEntity<String> backward() {
        String msg = "backward";
        System.out.println(msg);
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg , HttpStatus.OK);
    }

    @GetMapping("/behavior/backward/rotate/left")
    public ResponseEntity<String> backwardRotateLeft() {
        String msg = "backward-rotate-left";
        System.out.println(msg);
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg , HttpStatus.OK);
    }

    @GetMapping("/behavior/backward/rotate/right")
    public ResponseEntity<String> backwardRotateRight() {
        String msg = "backward-rotate-right";
        System.out.println(msg);
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg , HttpStatus.OK);
    }

    @GetMapping("/behavior/left")
    public ResponseEntity<String> goLeft() {
        String msg = "left";
        System.out.println(msg);
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg , HttpStatus.OK);
    }

    @GetMapping("/behavior/right")
    public ResponseEntity<String> goRight() {
        String msg = "right";
        System.out.println(msg);
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg , HttpStatus.OK);
    }
    @GetMapping("/behavior/rotate/left")
    public ResponseEntity<String> rotateLeft() {
        String msg = "rotate-left";
        System.out.println(msg);
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg , HttpStatus.OK);
    }
    @GetMapping("/behavior/rotate/right")
    public ResponseEntity<String> rotateRight() {
        String msg = "rotate-right";
        System.out.println(msg);
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg , HttpStatus.OK);
    }
    @GetMapping("/behavior/walk")
    public ResponseEntity<String> walk() {
        String msg = "walk";
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg , HttpStatus.OK);
    }
    @GetMapping("/behavior/stand")
    public ResponseEntity<String> stand() {
        String msg = "stand";
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg , HttpStatus.OK);
    }
    @GetMapping("/behavior/sit")
    public ResponseEntity<String> sit() {
        String msg = "sit";
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg , HttpStatus.OK);
    }
    @GetMapping("/behavior/stairs")
    public ResponseEntity<String> stairs() {
        String msg = "stairs";
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg , HttpStatus.OK);
    }
    @GetMapping("/behavior/self")
    public ResponseEntity<String> self() {
        String msg = "self";
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg , HttpStatus.OK);
    }

    @GetMapping("/behavior/stop")
    public ResponseEntity<String> stopWalking() {
        String msg = "STOP";
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg , HttpStatus.OK);
    }

    @GetMapping("/behavior/battery")
    public ResponseEntity<String> batteryChangePose() {
        String msg = "BAT";
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg , HttpStatus.OK);
    }

    @GetMapping("/behavior/jog")
    public ResponseEntity<String> jog() {
        String msg = "jog";
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg , HttpStatus.OK);
    }

    @GetMapping("/behavior/amble")
    public ResponseEntity<String> amble() {
        String msg = "amble";
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg , HttpStatus.OK);
    }

    @GetMapping("/behavior/crawl")
    public ResponseEntity<String> crawl() {
        String msg = "crawl";
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg , HttpStatus.OK);
    }

    @GetMapping("/behavior/hop")
    public ResponseEntity<String> hop() {
        String msg = "hop";
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg , HttpStatus.OK);
    }

    @GetMapping("/behavior/height/{val}")
    public ResponseEntity<String> setHeightWithJoystick(@PathVariable Integer val) {
        if (val < -1 || val > 1) {
            throw new RobotException("Invalid Height", HttpStatus.BAD_REQUEST);
        }
        String msg = "HEIGHT^" + val;
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg , HttpStatus.OK);
    }

    @PostMapping("/behavior/joystick")
    public ResponseEntity<JoystickAxes> joystickNormalMode(@RequestBody JoystickAxes joystickAxes) {
        float axis0 = Math.round(joystickAxes.getAxis0() * 100) / 100f;
        float axis1 = Math.round(joystickAxes.getAxis1() * 100) / 100f;
        float axis2 = Math.round(joystickAxes.getAxis2() * 100) / 100f;

        if (!axisIsInRange(axis0) || !axisIsInRange(axis1) || !axisIsInRange(axis2)) {
            throw new RobotException("Invalid Axes", HttpStatus.BAD_REQUEST);
        }
        String msg = "JOY-MOVE^" + axis0 + "^" + axis1 + "^" + axis2;
        sendMessageToZmq(msg);
        return new ResponseEntity<JoystickAxes>(new JoystickAxes(axis0, axis1, axis2), HttpStatus.OK);
    }

    @PostMapping("/behavior/joystick/stand")
    public ResponseEntity<JoystickAxesStandMode> joystickStandMode(@RequestBody JoystickAxesStandMode joystickAxes) {
        float axis0 = Math.round(joystickAxes.getAxis0() * 100) / 100f;
        float axis1 = Math.round(joystickAxes.getAxis1() * 100) / 100f;
        float axis2 = Math.round(joystickAxes.getAxis2() * 100) / 100f;
        float axis3 = Math.round(joystickAxes.getAxis3() * 100) / 100f;

        if (!axisIsInRange(axis0) || !axisIsInRange(axis1) || !axisIsInRange(axis2) || !axisIsInRange(axis3)) {
            throw new RobotException("Invalid Axes", HttpStatus.BAD_REQUEST);
        }
        String msg = "JOY-STAND^" + axis0 + "^" + axis1 + "^" + axis2 + "^" + axis3;
        sendMessageToZmq(msg);
        return new ResponseEntity<JoystickAxesStandMode>(new JoystickAxesStandMode(axis0, axis1, axis2, axis3), HttpStatus.OK);
    }

    @GetMapping("/behavior/arm/ok")
    public ResponseEntity<String> armOk() {
        String msg = "arm-ok";
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg , HttpStatus.OK);
    }

    @GetMapping("/behavior/arm/retry")
    public ResponseEntity<String> armRetry() {
        String msg = "arm-retry";
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg , HttpStatus.OK);
    }

    @GetMapping("/behavior/mission/{type}")
    public ResponseEntity<String> launchMission(@PathVariable char type) {
        if (Character.toUpperCase(type) != 'A' && Character.toUpperCase(type) != 'B') {
            throw new RobotException("Invalid Mission Type", HttpStatus.BAD_REQUEST);
        }
        String msg = "MISSION" + Character.toUpperCase(type);
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg , HttpStatus.OK);
    }

    @GetMapping("/behavior/pause/mission")
    public ResponseEntity<String> pauseMission() {
        String msg = "PAUSEMISSION";
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg , HttpStatus.OK);
    }

    @GetMapping("/behavior/restart/mission")
    public ResponseEntity<String> restartMission() {
        String msg = "RESTARTMISSION";
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg , HttpStatus.OK);
    }

    @GetMapping("/setting/speeds/{mode}")
    public ResponseEntity<String> setSpeed(@PathVariable char mode) {
        if (Character.toUpperCase(mode) != 'S' && Character.toUpperCase(mode) != 'M' && Character.toUpperCase(mode) != 'F') {
            throw new RobotException("Invalid Walk Mode", HttpStatus.BAD_REQUEST);
        }
        String msg = "SPEED-" + Character.toUpperCase(mode);
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg, HttpStatus.OK);
    }
    @GetMapping("/setting/pitch/{value}")
    public ResponseEntity<String> setPitch(@PathVariable Integer value) {
        if (value < 0 || value > 100) {
            throw new RobotException("Value Out Of Range", HttpStatus.BAD_REQUEST);

        }
        String msg = "PITCH-" + value;
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg, HttpStatus.OK);
    }
    @GetMapping("/setting/height/{value}")
    public ResponseEntity<String> setHeight(@PathVariable Integer value) {
        if (value < 0 || value > 100) {
            throw new RobotException("Value Out Of Range", HttpStatus.BAD_REQUEST);
        }
        String msg = "HEIGHT-" + value;
        sendMessageToZmq(msg);
        return new ResponseEntity<String>(msg, HttpStatus.OK);
    }

    private Boolean axisIsInRange(float axis) {
        if (Math.abs(axis) > 1.0) {
            return false;
        }
        return true;
    }

}
