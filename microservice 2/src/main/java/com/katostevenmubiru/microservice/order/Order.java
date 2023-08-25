package com.katostevenmubiru.microservice.order;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Long shoppingCartId;
    private Long customerId;
    private Long productId;
    private String orderStatus;

    // Constructors, getters, setters, and other methods

    // Constructor without arguments (default constructor)
    public Order() {
    }

    // Constructor with essential attributes
    public Order(Long shoppingCartId, Long customerId, Long productId, String orderStatus) {
        this.shoppingCartId = shoppingCartId;
        this.customerId = customerId;
        this.productId = productId;
        this.orderStatus = orderStatus;
    }

    // Getters and setters for all attributes

    public Long getOrderId() {
        return orderId;
    }

    public Long getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(Long shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
