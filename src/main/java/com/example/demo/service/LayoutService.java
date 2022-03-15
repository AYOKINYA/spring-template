package com.example.demo.service;

import com.example.demo.domain.mongo.Layout;
import com.example.demo.domain.mongo.LayoutRepository;
import com.example.demo.domain.mongo.LayoutUserRepository;
import com.example.demo.web.dto.LayoutRequest;
import com.example.demo.web.dto.LayoutResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class LayoutService {

    private final AuthService authService;
    private final LayoutUserRepository layoutUserRepository;
    private final LayoutRepository layoutRepository;

    public LayoutResponse save(LayoutRequest layoutRequest) {
        //delete current layouts in layout
        //delete current layoutIds in layoutUser
        //save new layoutIds in layoutUser
        //save new layouts in layout

    }

    public LayoutResponse getLayouts() {
        List<String> layoutIds = layoutUserRepository.findByUserId(authService.getCurrentUser().getUserId());

        List<Layout> layouts = new ArrayList<Layout>();
        for (String layoutId : layoutIds) {
            Layout l = layoutRepository.findByLayoutId(layoutId);
            layouts.add(l);
        }
    }
}
