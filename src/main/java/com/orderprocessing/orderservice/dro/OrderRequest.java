package com.orderprocessing.orderservice.dro;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Data
public class OrderRequest {
    @NotNull
    private String orderId;

    @NotNull
    private String customerName;

    @NotEmpty
    private List<Item> items;

    @NotNull
    private ZonedDateTime requestedAt;

    @NotNull
    private String correlationId;

    // Getters and Setters
    @Data
    public static class Item {
        @NotNull
        private String productId;

        @NotNull
        private Integer quantity;

        @NotNull
        private String category;

        // Getters and Setters
    }
}
