package com.orderprocessing.orderservice.service;

import com.orderprocessing.orderservice.dro.OrderRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {
    public String createOrder(OrderRequest orderRequest) {
        return UUID.randomUUID().toString();
    }
}
