package com.example.demo.service;
import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
import com.example.demo.domain.mongo.LayoutUser;
import com.example.demo.domain.mongo.LayoutUserRepository;
import com.example.demo.web.dto.LayoutDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class LayoutService {

    private final LayoutUserRepository layoutUserRepository;
    private final UserRepository userRepository;

    public LayoutDTO save(LayoutDTO layoutRequest) {
        User user = userRepository.findByUsername(layoutRequest.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException(layoutRequest.getUsername()));
        Optional<LayoutUser> layoutUser = layoutUserRepository.findById(user.getUserId());
        if (layoutUser.isPresent()) {
            layoutUserRepository.deleteById(user.getUserId());
        }

        layoutUserRepository.save(dtoToLayoutUser(user.getUserId(), layoutRequest));

        return layoutRequest;
    }

    private LayoutUser dtoToLayoutUser(Long id, LayoutDTO layoutDTO) {
        return LayoutUser.builder()
                .userId(id)
                .layouts(layoutDTO.getLayouts())
                .build();
    }

}
