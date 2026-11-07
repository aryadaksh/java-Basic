package com.snapdeal.dao;

import java.sql.Connection;
import java.util.List;

import com.snapdeal.model.OrderItem;

public interface OrderItemDAO {

    boolean save(OrderItem orderItem);

    boolean saveBatch(Long orderId,
                      List<OrderItem> orderItems,
                      Connection connection);

    List<OrderItem> findByOrderId(Long orderId);

    boolean deleteByOrderId(Long orderId);
}