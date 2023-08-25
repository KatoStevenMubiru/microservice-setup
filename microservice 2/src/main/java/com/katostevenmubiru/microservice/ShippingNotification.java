package com.katostevenmubiru.microservice;

public class ShippingNotification {
    private Long order_id;
    private Long customer_id;

    // Getters and setters

    public Long getOrderId() {
        return order_id;
    }

    public void setOrderId(Long order_id) {
        this.order_id = order_id;
    }

    public Long getCustomerId() {
        return customer_id;
    }

    public void setCustomerId(Long customer_id) {
        this.customer_id = customer_id;
    }
}
