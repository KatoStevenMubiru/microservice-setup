package com.katostevenmubiru.microservice;

public class NotificationPayload {
    private Long customer_id;
    private String message;

    // Getters and setters

    public Long getCustomerId() {
        return customer_id;
    }

    public void setCustomerId(Long customer_id) {
        this.customer_id = customer_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
