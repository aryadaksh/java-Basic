package com.model;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Order {
    private static final AtomicInteger UNIQUE_ID = new AtomicInteger(1000);

    private int orderId;
    private int customerId;
    private List<CartItem> items;
    private double totalAmount;
    private String orderStatus;
    private Date orderDate;

    // Constructor
    public Order(int customerId, List<CartItem> items) {
        this.orderId = UNIQUE_ID.incrementAndGet();
        this.customerId = customerId;
        this.items = new ArrayList<>(items);
        this.totalAmount = calculateTotal();
        this.orderStatus = "PLACED";
        this.orderDate = new Date();
    }

    // Getters
    public int getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    // Setters
    public void setOrderStatus(String status) {
        this.orderStatus = status;
    }

    // Helper
    private double calculateTotal() {
        return items.stream()
                    .mapToDouble(CartItem::getTotalPrice)
                    .sum();
    }

    @Override
    public String toString() {
        return "Order #" + orderId + " | Customer: " + customerId +
               " | Amount: Rs." + totalAmount +
               " | Status: " + orderStatus +
               " | Date: " + orderDate;
    }
}
