package com.snapdeal.model;


import java.time.LocalDateTime;

import com.snapdeal.enums.OrderStatus;

public class Order {

    private Long orderId;

    private Long customerId;

    private Double totalAmount;

    private LocalDateTime orderDate;

    private OrderStatus orderStatus;

    public Order() {

    }

    public Order(Long orderId,
                 Long customerId,
                 Double totalAmount,
                 LocalDateTime orderDate,
                 OrderStatus orderStatus) {

        this.orderId = orderId;
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {

        return String.format(
                "%-10d %-12d %-12.2f %-25s %-15s",
                orderId,
                customerId,
                totalAmount,
                orderDate,
                orderStatus);
    }
}