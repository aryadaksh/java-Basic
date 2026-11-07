package com.snapdeal.service;

import java.util.List;

import com.snapdeal.model.Cart;

public interface CartService {

    boolean addToCart(Cart cart);

    boolean removeFromCart(Long cartId);

    boolean increaseQuantity(Long cartId,
                             int quantity);

    boolean decreaseQuantity(Long cartId,
                             int quantity);

    List<Cart> viewCart(Long customerId);

    double calculateCartTotal(Long customerId);

    boolean clearCart(Long customerId);
}