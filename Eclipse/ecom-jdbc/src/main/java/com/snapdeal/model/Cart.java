package com.snapdeal.model;

public class Cart {

    private Long cartId;
    private Long customerId;
    private Long productId;
    private Integer quantity;

    public Cart() {
    }

    public Cart(Long cartId,
                Long customerId,
                Long productId,
                Integer quantity) {

        this.cartId = cartId;
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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

    @Override
    public String toString() {

        return "\n====================================" +
               "\nCART ITEM DETAILS" +
               "\n====================================" +
               "\nCart ID      : " + cartId +
               "\nCustomer ID  : " + customerId +
               "\nProduct ID   : " + productId +
               "\nQuantity     : " + quantity +
               "\n====================================";
    }
}