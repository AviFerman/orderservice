package com.orderprocessing.orderservice.dto;

import com.orderprocessing.orderservice.enums.CategoryEnum;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {
    private String productId;
    private Integer quantity;
    private CategoryEnum category;

}
