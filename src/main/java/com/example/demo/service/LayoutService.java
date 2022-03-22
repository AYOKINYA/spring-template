package com.example.demo.service;
import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
import com.example.demo.domain.mongo.Layout;
import com.example.demo.domain.mongo.LayoutUser;
import com.example.demo.domain.mongo.LayoutUserRepository;
import com.example.demo.web.dto.LayoutDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class LayoutService {

    private final LayoutUserRepository layoutUserRepository;
    private final UserRepository userRepository;

    public LayoutDTO save(LayoutDTO layoutRequest) {
        User user = userRepository.findByUsername(layoutRequest.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException(layoutRequest.getUsername()));
        Optional<LayoutUser> layoutUser = layoutUserRepository.findByUserId(user.getUserId());
        if (layoutUser.isPresent()) {
            layoutUserRepository.deleteByUserId(user.getUserId());
        }
        LayoutUser newLayoutUser = dtoToLayoutUser(user.getUserId(), layoutRequest);
        layoutUserRepository.save(newLayoutUser);

        return new LayoutDTO(user.getUsername(), newLayoutUser.getLayouts());
    }

    public LayoutDTO getLayouts(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        LayoutUser layoutUser = layoutUserRepository.findByUserId(user.getUserId())
                .orElseThrow(() -> new UsernameNotFoundException(username));

        return new LayoutDTO(username, layoutUser.getLayouts());
    }

    private LayoutUser dtoToLayoutUser(Long id, LayoutDTO layoutDTO) {
        return LayoutUser.builder()
                .userId(id)
                .layouts(layoutDTO.getLayouts()
                        .stream()
                        .map(layout -> (layout.getLayoutId() == null) ?  new Layout(layout.getLayoutName(), layout.getItems()) : new Layout(layout.getLayoutId(), layout.getLayoutName(), layout.getItems()))
                        .collect(Collectors.toList()))
                .build();
    }


}
