package com.orderprocessing.orderservice.dto;

import com.orderprocessing.orderservice.enums.OrderStatusEnum;
import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Builder
@Data
public class OrderEvent {
    private String orderId;
}
