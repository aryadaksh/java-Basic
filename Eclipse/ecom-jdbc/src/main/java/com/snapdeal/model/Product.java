package com.snapdeal.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Product extends AuditEntity {

    private Long productId;
    private String productName;
    private String category;
    private BigDecimal price;
    private Integer quantity;
    private String brand;

    public Product() {
    }

    public Product(Long productId,
                   String productName,
                   String category,
                   BigDecimal price,
                   Integer quantity,
                   String brand) {

        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {

        return "\n🛒 PRODUCT DETAILS" +
               "\n--------------------------------" +
               "\nID       : " + productId +
               "\nName     : " + productName +
               "\nCategory : " + category +
               "\nBrand    : " + brand +
               "\nPrice    : ₹" + price +
               "\nStock    : " + quantity +
               "\n--------------------------------";
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;

        if (!(o instanceof Product))
            return false;

        Product product = (Product) o;

        return Objects.equals(
                productId,
                product.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
}