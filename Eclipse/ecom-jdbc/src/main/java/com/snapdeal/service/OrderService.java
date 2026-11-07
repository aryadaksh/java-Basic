package com.snapdeal.service;

import java.util.List;

import com.snapdeal.model.Order;

public interface OrderService {

    boolean placeOrder(Long customerId);

    Order getOrderById(Long orderId);

    List<Order> getCustomerOrders(Long customerId);

    List<Order> getAllOrders();

    boolean cancelOrder(Long orderId);

    List<Order> getOrderHistory(Long customerId);
}