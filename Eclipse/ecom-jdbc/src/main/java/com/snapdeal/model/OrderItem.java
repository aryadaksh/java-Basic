package com.snapdeal.model;

import java.util.Objects;

public class OrderItem {

    private Long orderItemId;

    private Long orderId;

    private Long productId;

    private Integer quantity;

    private Double itemPrice;

    public OrderItem() {

    }

    public OrderItem(Long orderItemId,
                     Long orderId,
                     Long productId,
                     Integer quantity,
                     Double itemPrice) {

        this.orderItemId = orderItemId;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {

        return String.format(
                "%-10d %-10d %-10d %-10d ₹%-10.2f",
                orderItemId,
                orderId,
                productId,
                quantity,
                itemPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderItemId);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        OrderItem other = (OrderItem) obj;

        return Objects.equals(
                orderItemId,
                other.orderItemId);
    }
}