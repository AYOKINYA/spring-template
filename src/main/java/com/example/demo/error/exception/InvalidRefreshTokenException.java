package com.example.demo.error.exception;

public class InvalidRefreshTokenException extends RuntimeException{

    public InvalidRefreshTokenException (String message) {
        super(message);
    }

}