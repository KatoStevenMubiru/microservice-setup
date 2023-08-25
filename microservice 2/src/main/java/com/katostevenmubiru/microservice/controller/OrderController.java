package com.katostevenmubiru.microservice.controller;

import com.katostevenmubiru.microservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/request")
    public String createOrderRequest(@RequestBody OrderRequestPayload payload) {
        Long shoppingCartId = payload.getShoppingCartId();

        // Perform the necessary logic, like creating an order and determining product location
        String productLocation = orderService.determineProductLocation(shoppingCartId);

        // Return a response based on the determined product location
        return "Order placed. Product will be shipped from " + productLocation;
    }

    // Inner class to represent the order request payload
    static class OrderRequestPayload {
        private Long shoppingCartId;

        public Long getShoppingCartId() {
            return shoppingCartId;
        }

        public void setShoppingCartId(Long shoppingCartId) {
            this.shoppingCartId = shoppingCartId;
        }
    }
}
