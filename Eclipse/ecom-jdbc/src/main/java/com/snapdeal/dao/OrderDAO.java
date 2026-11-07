package com.snapdeal.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

import com.snapdeal.enums.OrderStatus;
import com.snapdeal.model.Order;

public interface OrderDAO {

    boolean save(Order order);

    Long createOrder(Long customerId,
                     Double totalAmount,
                     Connection connection);

    Optional<Order> findById(Long orderId);

    List<Order> findByCustomerId(Long customerId);

    List<Order> findAll();

    boolean updateOrderStatus(Long orderId,
                              OrderStatus orderStatus);

    boolean cancelOrder(Long orderId);

}