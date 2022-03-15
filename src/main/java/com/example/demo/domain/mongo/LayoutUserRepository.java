package com.example.demo.domain.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LayoutUserRepository extends MongoRepository<LayoutUser, Long> {

    List<String> findByUserId(Long userId);
}
