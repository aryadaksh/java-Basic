package com.zepto.delivery;

import com.zepto.order.Order;

public class DeliveryService {

    public boolean assignDelivery(Order order) {

        System.out.println("Assigning delivery...");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Address: "
                + order.getDeliveryAddress());

        System.out.println("Normal delivery assigned.");

        return true;
    }

    public boolean oneDayDelivery(Order order) {

        System.out.println("================================");
        System.out.println("1-DAY DELIVERY SELECTED");
        System.out.println("================================");

        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Customer: "
                + order.getCustomerName());

        System.out.println("Delivery Address: "
                + order.getDeliveryAddress());

        System.out.println("Expected delivery: Tomorrow");
        System.out.println("Priority delivery assigned!");

        return true;
    }

    public void trackDelivery(Order order) {

        System.out.println("Tracking delivery...");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Status: Out for delivery");
    }
}