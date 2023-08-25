package com.katostevenmubiru.microservice.repository;



import com.katostevenmubiru.microservice.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Object> findById(Long orderId);
    // You can add custom query methods here if needed
}
