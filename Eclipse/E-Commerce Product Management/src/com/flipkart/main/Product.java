package com.flipkart.main;

import java.util.concurrent.atomic.AtomicInteger;

public class Product {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
    private int productId;
    private String productName;
    private String category;
    private double price;
    private int quantity;
    private String brand;

    public Product(String productName, String category, double price, int quantity, String brand) {
        this.productId = ID_GENERATOR.incrementAndGet();
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
    }

    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String getBrand() { return brand; }

    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return productId + " - " + productName + " (" + brand + ") Rs." + price + " Stock:" + quantity;
    }
}
