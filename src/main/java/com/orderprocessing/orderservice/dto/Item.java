package com.orderprocessing.orderservice.dto;

import com.orderprocessing.orderservice.enums.CategoryEnum;
import com.orderprocessing.orderservice.enums.ItemAvailabilityEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {
    private String productId;
    private Integer quantity;
    private CategoryEnum category;
    private ItemAvailabilityEnum availability;

}
