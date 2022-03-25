package com.example.demo.domain.mongo;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface LayoutUserRepository extends MongoRepository<LayoutUser, Long> {

    @Aggregation(pipeline = {
            "{'$unwind': '$layouts'}",
            "{'$sort': {'layouts.layoutName': 1}}",
            "{'$group': {_id: '$_id', layouts: {$push:'$layouts'}}}"
    })
    Optional<LayoutUser> findByUserIdOrderByLayoutName(Long userId);
    void deleteByUserId(Long userId);
}
