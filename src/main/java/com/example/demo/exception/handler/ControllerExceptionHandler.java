package com.example.demo.exception.handler;

import com.example.demo.exception.DemoException;
import com.example.demo.exception.PostNotFoundException;
import com.example.demo.exception.errormessage.ErrorMessage;
import com.example.demo.exception.errorcode.PostErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(PostNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage PostNotFoundException(WebRequest request) {
        ErrorMessage msg = ErrorMessage.builder()
                .statusCode(PostErrorCode.PostNotFound.getCode())
                .message(PostErrorCode.PostNotFound.getMessage())
                .description(request.getDescription(false))
                .timestamp(new Date())
                .build();

        return msg;
    }

    @ExceptionHandler(DemoException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage demoExceptionHandler(DemoException ex, WebRequest request) {
        ErrorMessage msg = ErrorMessage.builder()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(ex.getMessage())
                .description(request.getDescription(false))
                .timestamp(new Date())
                .build();
        return msg;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage globalExceptionHandler(Exception ex, WebRequest request) {
        ErrorMessage msg = ErrorMessage.builder()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(ex.getMessage())
                .description(request.getDescription(false))
                .timestamp(new Date())
                .build();

        return msg;
    }
}
