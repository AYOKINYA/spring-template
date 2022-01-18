package com.example.demo.service;

import com.example.demo.domain.*;
import com.example.demo.web.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Transactional
    public void signup(RegisterRequest registerRequest) {

        Set<Role> defaultRoles = new HashSet<>();
        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        defaultRoles.add(userRole);

        User user = User.builder()
                .username(registerRequest.getUsername())
                .password(encodePassword(registerRequest.getPassword()))
                .email(registerRequest.getEmail())
                .created(Instant.now())
                .enabled(true)
                .roles(defaultRoles)
                .build();

        userRepository.save(user);

    }

    private String encodePassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
