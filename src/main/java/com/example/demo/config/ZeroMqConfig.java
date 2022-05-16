package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.zeromq.ZContext;

@Configuration
public class ZeroMqConfig {

    @Bean
    public ZContext zContext() {
        return new ZContext();
    }

    @Bean
    public ZContext zContext2() {
        return new ZContext();
    }

    @Bean
    public ZmqPubObj zmqPubObj() {
        return new ZmqPubObj(zContext());
    }

    @Bean
    public ZmqSubObj zmqSubObj() {
        return new ZmqSubObj(zContext2());
    }

}
