package com.model;

public class CartItem {
    private int productId;
    private String productName;
    private double price;
    private int quantity;

    public CartItem(int productId, String productName, double price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Derived value
    public double getTotalPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return productName + " x " + quantity + " = Rs." + getTotalPrice();
    }
}
