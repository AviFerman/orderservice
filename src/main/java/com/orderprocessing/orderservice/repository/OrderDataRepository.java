package com.orderprocessing.orderservice.repository;

import com.orderprocessing.orderservice.dto.OrderData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderDataRepository extends CrudRepository<OrderData, String> {
    Optional<OrderData> findByOrderId(String orderId);
}
