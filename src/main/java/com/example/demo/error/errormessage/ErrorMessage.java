package com.example.demo.error.errormessage;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
public class ErrorMessage {

    private int statusCode;
    private String message;
    private String description;
    private Date timestamp;

    @Builder
    ErrorMessage(int statusCode, String message, String description, Date timestamp) {
        this.statusCode = statusCode;
        this.message = message;
        this.description = description;
        this.timestamp = timestamp;
    }
}
