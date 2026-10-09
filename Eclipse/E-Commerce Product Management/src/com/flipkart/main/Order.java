package com.flipkart.main;




import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Order {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(2000);

    private int orderId;
    private int customerId;
    private List<CartItem> items;
    private double totalAmount;
    private String orderStatus;
    private Date orderDate;

    public Order(int customerId, List<CartItem> items) {
        this.orderId = ID_GENERATOR.incrementAndGet();
        this.customerId = customerId;
        this.items = new ArrayList<>(items);
        this.totalAmount = calculateTotal();
        this.orderStatus = "PLACED";
        this.orderDate = new Date();
    }

    private double calculateTotal() {
        return items.stream().mapToDouble(CartItem::getTotalPrice).sum();
    }

    public int getOrderId() { return orderId; }
    public int getCustomerId() { return customerId; }
    public double getTotalAmount() { return totalAmount; }
    public String getOrderStatus() { return orderStatus; }
    public void setOrderStatus(String status) { this.orderStatus = status; }

    @Override
    public String toString() {
        return "Order #" + orderId + " | Customer: " + customerId +
               " | Amount: Rs." + totalAmount +
               " | Status: " + orderStatus +
               " | Date: " + orderDate;
    }
}
