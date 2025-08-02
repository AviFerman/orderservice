package com.orderprocessing.orderservice.dto;

import com.orderprocessing.orderservice.enums.CategoryEnum;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.List;

@Data
public class OrderRequest {
    @NotEmpty
    private String orderId;

    @NotEmpty
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
        @NotEmpty
        private String productId;

        @NotNull
        @Min(0)
        private Integer quantity;

        @NotNull
        private CategoryEnum category;

        // Getters and Setters
    }
}
