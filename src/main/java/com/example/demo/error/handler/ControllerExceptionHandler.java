package com.example.demo.error.handler;

import com.example.demo.error.errorcode.ErrorCode;
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

import java.time.LocalDateTime;
import java.util.Date;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(PostNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage PostNotFoundException(WebRequest request) {
        return makeErrorMessage(PostErrorCode.PostNotFound, request);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(UsernameNotFoundException.class)
    public ErrorMessage UsernameNotFoundExceptionHandler(UsernameNotFoundException ex, WebRequest request) {
        return makeErrorMessage(HttpStatus.NOT_FOUND.value(), ex, request);
    }

    @ExceptionHandler(InvalidRefreshTokenException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorMessage InvalidRefreshTokenExceptionHandler(WebRequest request) {
        return makeErrorMessage(JWTErrorCode.InvalidRefreshTokenError, request);
    }

    @ExceptionHandler(DemoException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage demoExceptionHandler(DemoException ex, WebRequest request) {
        return makeErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex, request);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage globalExceptionHandler(Exception ex, WebRequest request) {
        return makeErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex, request);
    }

    private ErrorMessage makeErrorMessage(ErrorCode errorCode, WebRequest request) {
        ErrorMessage msg = ErrorMessage.builder()
                .statusCode(errorCode.getCode())
                .message(errorCode.getMessage())
                .description(request.getDescription(false))
                .timestamp(LocalDateTime.now())
                .build();

        return msg;
    }

    private ErrorMessage makeErrorMessage(int code, Exception ex, WebRequest request) {
        ErrorMessage msg = ErrorMessage.builder()
                .statusCode(code)
                .message(ex.getMessage())
                .description(request.getDescription(false))
                .timestamp(LocalDateTime.now())
                .build();

        return msg;
    }
}
