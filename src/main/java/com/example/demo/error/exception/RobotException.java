package com.example.demo.error.exception;

import org.springframework.http.HttpStatus;

public class RobotException extends CustomException{
    public RobotException(String message, HttpStatus status) { super(message, status); }
}
