package com.example.demo.web.controller;

import com.example.demo.domain.mongo.Layout;
import com.example.demo.service.LayoutService;
import com.example.demo.web.domain.LayoutRequest;
import com.example.demo.web.dto.LayoutRequest;
import com.example.demo.web.dto.LayoutResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.ResponseEntity.status;

@Controller
@RequestMapping("/api/v1/layouts")
@RequiredArgsConstructor
public class LayoutController {

    private final LayoutService;

    @PostMapping
    public ResponseEntity<LayoutResponse> saveLayout(@RequestBody LayoutRequest layoutRequest) {
        LayoutResponse res = LayoutService.save(layoutRequest);
        return status(HttpStatus.CREATED).body(res);
    }
}
