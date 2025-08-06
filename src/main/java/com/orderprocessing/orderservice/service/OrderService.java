package com.orderprocessing.orderservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.orderprocessing.orderservice.dto.OrderData;
import com.orderprocessing.orderservice.dto.OrderEvent;
import com.orderprocessing.orderservice.dto.OrderRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.orderprocessing.orderservice.utils.OrderServiceMapper.mapOrderRequestToOrderData;

@Slf4j
@AllArgsConstructor
@Service
public class OrderService {
    private final RedisService redisService;
    private final KafkaProducerService kafkaProducerService;

    public String createOrder(OrderRequest orderRequest) throws JsonProcessingException {

        log.info("createOrder:: Processing order request: {}", orderRequest);
        OrderData orderData = mapOrderRequestToOrderData(orderRequest);
        redisService.writeJson("order:" + orderData.getOrderId(), orderData);
        log.info("createOrder:: Order stored in Redis with ID: {} and OrderData {}", orderData.getOrderId(), orderData);
        kafkaProducerService.sendOrderEvent(OrderEvent.builder()
                .orderId(orderData.getOrderId())
                .build());
        log.info("createOrder:: OrderEvent sent to Kafka");
        return orderData.getOrderId();
    }
}
