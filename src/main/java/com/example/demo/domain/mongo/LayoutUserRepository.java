package com.example.demo.domain.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface LayoutUserRepository extends MongoRepository<LayoutUser, Long> {
    Optional<LayoutUser> findByUserId(Long userId);
    void deleteByUserId(Long userId);
}
