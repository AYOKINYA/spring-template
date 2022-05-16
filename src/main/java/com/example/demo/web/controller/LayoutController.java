package com.example.demo.web.controller;

import com.example.demo.service.LayoutService;
import com.example.demo.web.dto.LayoutDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/api/v1/layouts")
@RequiredArgsConstructor
public class LayoutController {

    private final LayoutService layoutService;

    @PostMapping
    public ResponseEntity<LayoutDTO> saveLayout(@RequestBody LayoutDTO layoutRequest) {
        LayoutDTO res = layoutService.save(layoutRequest);
        return status(HttpStatus.CREATED).body(res);
    }

    @GetMapping("/{username}")
    public ResponseEntity<LayoutDTO> getLayouts(@PathVariable String username) {
        LayoutDTO res = layoutService.getLayouts(username);
        return status(HttpStatus.OK).body(res);
    }
}
