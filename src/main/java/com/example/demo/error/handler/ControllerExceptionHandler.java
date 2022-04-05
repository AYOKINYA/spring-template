package com.example.demo.error.handler;

import com.example.demo.error.exception.DemoException;
import com.example.demo.error.exception.InvalidRefreshTokenException;
import com.example.demo.error.exception.PostNotFoundException;
import com.example.demo.error.errorcode.JWTErrorCode;
import com.example.demo.error.errormessage.ErrorMessage;
import com.example.demo.error.errorcode.PostErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(UsernameNotFoundException.class)
    public ErrorMessage UsernameNotFoundExceptionHandler(UsernameNotFoundException ex, WebRequest request) {
        ErrorMessage msg = ErrorMessage.builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .description(request.getDescription(false))
                .timestamp(new Date())
                .build();
        return msg;
    }

    @ExceptionHandler(InvalidRefreshTokenException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage InvalidRefreshTokenExceptionHandler(WebRequest request) {
        ErrorMessage msg = ErrorMessage.builder()
                .statusCode(JWTErrorCode.InvalidRefreshTokenError.getCode())
                .message(JWTErrorCode.InvalidRefreshTokenError.getMessage())
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
