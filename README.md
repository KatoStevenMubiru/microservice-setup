# Microservice E-commerce Application

Welcome to the Microservice E-commerce Application! This repository contains the implementation of a simplified microservice-based e-commerce application. The main focus is on designing and implementing an Order Service that handles customer orders, product location determination, and communication with other services.

## High-Level Architecture

The microservice architecture consists of several components:

- **Order Service:** Handles customer orders, product location determination, and communication with other services.
- **Shipping Service:** Manages shipping-related operations and notifications.
- **Notification Service:** Handles notifications to customers about order status.

## Setup and Running the Application

Follow these steps to set up and run the application:

1. Clone the repository:
   ```sh
   git clone https://github.com/KatoStevenMubiru/microservice-e-commerce.git
   cd microservice-e-commerce
   
2. Build the application using Maven:
   ```sh
   mvn clean install
    
3. Run the application:
   ```sh
   mvn spring-boot:run
   
4. Access the application:
   The application will be accessible at http://localhost:8080.

## API Documentation

Create Order
Create a new order by sending a POST request to /orders/request.

Request Body:
```json
{
   "shopping_cart_id": 1
}
```

Notify Shipping Service
Notify the Shipping Service about an order by sending a POST request to /orders/api/shipping/receive.

Request Body:
```json
{
   "order_id": 1,
   "customer_id": 1
}
```
Notify Notification Service
Notify the Notification Service about an order's state by sending a POST request to /orders/notifications/send.

Request Body:
```
{
   "customer_id": 1,
   "message": "Order completed"
}
```
## List All Orders
Get a list of all orders by sending a GET request to /orders.

Considerations

The microservice architecture promotes modularity, scalability, and maintainability.
Error handling and resilience mechanisms should be implemented for production use.
Secure communication (HTTPS) and authentication/authorization mechanisms should be added for real-world applications.
Database design and performance optimization should be considered for efficient data retrieval.





