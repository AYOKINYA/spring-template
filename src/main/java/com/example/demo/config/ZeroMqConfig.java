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
    public ZmqObj zmqObj() {
        return new ZmqObj(zContext());
    }

}
