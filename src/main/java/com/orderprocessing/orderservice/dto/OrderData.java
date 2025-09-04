package com.orderprocessing.orderservice.dto;

import com.orderprocessing.orderservice.enums.OrderStatusEnum;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@RedisHash("OrderData")
public class OrderData implements Serializable {

    @Id
    private String orderId;
    private String customerName;
    private ZonedDateTime requestedAt;
    private String correlationId;
    private List<Item> items;
    private OrderStatusEnum orderStatus;
}