package com.orderprocessing.orderservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.orderprocessing.orderservice.dto.OrderData;
import com.orderprocessing.orderservice.dto.OrderRequest;
import com.orderprocessing.orderservice.utils.OrderServiceMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.orderprocessing.orderservice.utils.OrderServiceMapper.mapOrderRequestToOrderData;

@Slf4j
@AllArgsConstructor
@Service
public class OrderService {
    private final RedisService redisService;

    public String createOrder(OrderRequest orderRequest) throws JsonProcessingException {

        log.info("createOrder:: Processing order request: {}", orderRequest);
        OrderData orderData = mapOrderRequestToOrderData(orderRequest);

        redisService.writeJson("order:" + orderData.getOrderId(), orderData);
        log.info("createOrder:: Order stored in Redis with ID: {} and OrderData {}", orderData.getOrderId(), orderData);
        return UUID.randomUUID().toString();
    }


}
