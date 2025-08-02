package com.orderprocessing.orderservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.orderprocessing.orderservice.dro.OrderRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Service
public class OrderService {
    private final RedisService redisService;

    public String createOrder(OrderRequest orderRequest) throws JsonProcessingException {

        log.info("createOrder:: Processing order request: {}", orderRequest);
        String orderId = UUID.randomUUID().toString();
        redisService.writeJson("order:" + orderId, orderRequest);
        return UUID.randomUUID().toString();
    }
}
