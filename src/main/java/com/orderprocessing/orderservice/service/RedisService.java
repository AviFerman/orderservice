package com.orderprocessing.orderservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisService {

    private final StringRedisTemplate redisTemplate;
    private final ObjectMapper objectMapper;

    public void writeJson(String key, Object value) throws JsonProcessingException {
        String jsonValue = objectMapper.writeValueAsString(value);
        redisTemplate.opsForValue().set(key, jsonValue);
        log.info("writeJson:: Stored JSON in Redis with key: {}", key);

    }
}
