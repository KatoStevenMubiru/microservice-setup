package com.katostevenmubiru.microservice.controller;

import com.katostevenmubiru.microservice.NotificationPayload;
import com.katostevenmubiru.microservice.ShippingNotification;
import com.katostevenmubiru.microservice.order.Order;
import com.katostevenmubiru.microservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Value("${app.base-url}")
    private String baseUrl;

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
    @GetMapping
    /*public ResponseEntity<List<Order>> listAllOrders() {
        List<Order> orders = orderService.getAllOrders(); // Assuming you have a method to retrieve all orders from the service
        return ResponseEntity.ok(orders);
    }*/
    @PostMapping("/api/shipping/receive")
    public ResponseEntity<String> notifyShippingService(@RequestBody ShippingNotification notification) {
        // Extract order_id and customer_id from the notification

        Long orderId = notification.getOrderId();
        Long customerId = notification.getCustomerId();

        // Construct the complete URL for the Shipping Service endpoint
        String shippingServiceEndpoint = baseUrl + "/api/shipping/receive";

        // Perform any necessary logic or processing

        // Simulate sending the notification to the Shipping Service
        String responseFromShippingService = sendNotificationToShippingService(orderId, customerId);

        return ResponseEntity.ok(responseFromShippingService);
    }
    @PostMapping("/notifications/send")
    public ResponseEntity<String> notifyNotificationService(@RequestBody NotificationPayload payload) {
        Long customerId = payload.getCustomerId();
        String message = payload.getMessage();

        // Perform any necessary logic or processing

        // Simulate sending the notification to the Notification Service
        String responseFromNotificationService = sendNotificationToNotificationService(customerId, message);

        return ResponseEntity.ok(responseFromNotificationService);
    }
    private String sendNotificationToShippingService(Long orderId, Long customerId) {
        // Simulate sending the notification by printing a message
        System.out.println("Sending notification to Shipping Service:");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer ID: " + customerId);

        // In a real scenario, you would use an HTTP client to send a POST request
        // to the Shipping Service's endpoint with the JSON payload
        // Example using Spring WebClient:
        // WebClient client = WebClient.create("https://shipping-service-url/api/notify");
        // String response = client.post()
        //     .bodyValue(notification)
        //     .retrieve()
        //     .bodyToMono(String.class)
        //     .block();

        return "Notification sent to Shipping Service";
    }
    private String sendNotificationToNotificationService(Long customerId, String message) {
        // Use an HTTP client to send the notification to the Notification Service's endpoint
        // Example using Spring WebClient:
        // WebClient client = WebClient.create("https://notification-service-url/api/notify");
        // NotificationPayload payload = new NotificationPayload();
        // payload.setCustomerId(customerId);
        // payload.setMessage(message);
        // String response = client.post()
        //     .bodyValue(payload)
        //     .retrieve()
        //     .bodyToMono(String.class)
        //     .block();

        // Simulate the response from the Notification Service
        return "Notification sent to Notification Service";
    }
}
