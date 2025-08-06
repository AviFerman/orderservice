package com.orderprocessing.orderservice.dto;

import com.orderprocessing.orderservice.enums.OrderStatusEnum;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Data
public class OrderData {
    private String orderId;
    private String customerName;
    private ZonedDateTime requestedAt;
    private String correlationId;
    private List<Item> items;
    private OrderStatusEnum orderStatus;
}
