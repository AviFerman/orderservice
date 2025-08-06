package com.orderprocessing.orderservice.api;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.orderprocessing.orderservice.dto.OrderRequest;
import com.orderprocessing.orderservice.service.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/orders")
@Validated
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<String> createOrder(@Valid @RequestBody OrderRequest orderRequest) throws JsonProcessingException {
        log.info("createOrder:: Received order request: {}", orderRequest);
        String orderId = orderService.createOrder(orderRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Order received with ID: " + orderId);
    }
}
