package com.example.demo.error.errorcode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum PostErrorCode implements  ErrorCode {

    PostNotFound(HttpStatus.NOT_FOUND.value(), "Post is not found.");

    private final int       code;
    private final String    message;

}