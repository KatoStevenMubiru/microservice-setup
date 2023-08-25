package com.katostevenmubiru.microservice.service;

import com.katostevenmubiru.microservice.order.Order;
import com.katostevenmubiru.microservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Implement your logic to determine product location based on order details
    // You can use the OrderRepository to fetch order details and then use those details for the logic
    public String determineProductLocation(Long orderId) {
        // Example logic:
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            // Implement your logic here to determine product location based on order details
            // For example, you might check product availability and customer's profile
            return "Location A";  // Replace with your actual determination logic
        } else {
            return "Order not found";
        }
    }

    /*public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }*/
}
