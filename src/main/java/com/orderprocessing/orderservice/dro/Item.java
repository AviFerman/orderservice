package com.orderprocessing.orderservice.dro;

import com.orderprocessing.orderservice.enums.CategoryEnum;
import jakarta.validation.constraints.NotNull;

public class Item {
    private String productId;
    private Integer quantity;
    private CategoryEnum category;
}
