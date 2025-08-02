package com.orderprocessing.orderservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisService {

    private final RedisTemplate<String, String> redisTemplate;
    private final ObjectMapper objectMapper;

    public void writeJson(String key, Object value) throws JsonProcessingException {
        String jsonValue = objectMapper.writeValueAsString(value);
        redisTemplate.opsForValue().set(key, jsonValue);
        log.info("writeJson:: Stored JSON in Redis with key: {}", key);

    }

    public <T> T readJson(String key, Class<T> valueType) throws JsonProcessingException {
        String jsonValue = redisTemplate.opsForValue().get(key);
        return objectMapper.readValue(jsonValue, valueType);
    }
}
