package com.example.demo.domain.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LayoutRepository extends MongoRepository<Layout, String> {

    Layout findByLayoutId(String layoutId);
}
