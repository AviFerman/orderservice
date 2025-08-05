package com.orderprocessing.orderservice.utils;

import com.orderprocessing.orderservice.dto.Item;
import com.orderprocessing.orderservice.dto.OrderData;
import com.orderprocessing.orderservice.dto.OrderRequest;
import com.orderprocessing.orderservice.enums.OrderStatusEnum;

import java.util.UUID;
import java.util.stream.Collectors;

public class OrderServiceMapper {

    public static OrderData mapOrderRequestToOrderData(OrderRequest orderRequest) {
        OrderData orderData = new OrderData();
        orderData.setOrderId(orderRequest.getOrderId());
        orderData.setCustomerName(orderRequest.getCustomerName());
        orderData.setItems(orderRequest.getItems().stream()
                .map(item -> Item.builder()
                        .productId(item.getProductId())
                        .quantity(item.getQuantity())
                        .category(item.getCategory())
                        .availability(null)
                        .build()) // Map properties from OrderRequest.Item to Item
                .collect(Collectors.toList()));
        orderData.setRequestedAt(orderRequest.getRequestedAt());
        orderData.setCorrelationId(orderRequest.getCorrelationId());
        orderData.setOrderStatus(OrderStatusEnum.PENDING); // Assuming orderRequest has orderStatus
        orderData.setOrderId(UUID.randomUUID().toString());;
        return orderData;
    }

}

