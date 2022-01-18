package com.example.demo.web.controller;


import com.example.demo.service.AuthService;
import com.example.demo.web.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody RegisterRequest registerRequest) {
        authService.signup(registerRequest);
        System.out.println(registerRequest.getUsername());
        System.out.println(registerRequest.getEmail());
        System.out.println(registerRequest.getPassword());
        return new ResponseEntity("User Registration Successful", HttpStatus.OK);
    }
}
