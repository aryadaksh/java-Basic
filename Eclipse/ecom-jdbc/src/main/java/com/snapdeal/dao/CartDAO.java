package com.snapdeal.dao;

import java.sql.Connection;
import java.util.List;

import com.snapdeal.model.Cart;

public interface CartDAO {

    boolean addToCart(Cart cart);

    boolean removeFromCart(Long cartId);

    boolean updateCartQuantity(Long cartId, int quantity);

    List<Cart> getCustomerCart(Long customerId);

    double calculateCartTotal(Long customerId);

    boolean clearCart(Long customerId);

    // Used during Order Transaction
    boolean clearCart(Long customerId, Connection connection);
}