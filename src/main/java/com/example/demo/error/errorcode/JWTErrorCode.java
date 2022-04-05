package com.example.demo.error.errorcode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum JWTErrorCode {

    InvalidRefreshTokenError(HttpStatus.BAD_REQUEST.value(), "Invalid refresh Token");

    private final int       code;
    private final String    message;
}
