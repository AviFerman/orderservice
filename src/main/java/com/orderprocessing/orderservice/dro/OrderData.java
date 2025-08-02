package com.orderprocessing.orderservice.dro;

import com.orderprocessing.orderservice.enums.OrderStatusEnum;

import java.time.ZonedDateTime;
import java.util.List;

public class OrderData {

    private String orderId;
    private String customerName;
    private ZonedDateTime requestedAt;
    private String correlationId;
    private List<Item> items;
    private OrderStatusEnum orderStatus;
}
