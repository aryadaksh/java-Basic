package com.zepto.inventoryservice;

import com.zepto.order.Order;

public class InventoryService {

    public boolean checkStock(Order order) {

        System.out.println("Checking inventory...");
        System.out.println("Product: " + order.getProductName());
        System.out.println("Quantity: " + order.getQuantity());

        // Dummy inventory logic
        if (order.getQuantity() <= 5) {
            System.out.println("Product is in stock.");
            return true;
        }

        System.out.println("Product is out of stock.");
        return false;
    }

    public boolean reserveStock(Order order) {

        System.out.println("Reserving stock...");
        System.out.println("Reserved " 
                + order.getQuantity() 
                + " item(s).");

        return true;
    }
}