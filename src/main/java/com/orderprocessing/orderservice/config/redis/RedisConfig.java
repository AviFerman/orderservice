//package com.orderprocessing.orderservice.config.redis;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnection;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//
//@Configuration
//@Slf4j
//public class RedisConfig {
//
//    @Value("${spring.redis.host}")
//    private String redisHost;
//
//    @Bean
//    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory connectionFactory) {
//        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(connectionFactory);
//
//        // Log Redis connection info
//        RedisConnection connection = connectionFactory.getConnection();
//        log.info("Redis connection properties: {}", connection.getClientList());
//        log.info("Redis server info: {}", connection.info());
//        log.info("Redis HOST: {}", redisHost);
//
//        return redisTemplate;
//    }
//}