package com.snapdeal.dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.snapdeal.enums.OrderStatus;
import com.snapdeal.model.Order;

public class OrderDAOImplTest {

    private final OrderDAOImpl orderDAO =
            new OrderDAOImpl();

    @Test
    void testSaveOrder() {

        Order order = new Order();

        order.setCustomerId(1L);
        order.setTotalAmount(1500.00);
        order.setOrderDate(
                LocalDateTime.now());
        order.setOrderStatus(
                OrderStatus.PLACED);

        boolean result =
                orderDAO.save(order);

        assertTrue(result);
    }

    @Test
    void testFindById() {

        Optional<Order> order =
                orderDAO.findById(1L);

        assertTrue(
                order.isPresent());
    }

    @Test
    void testFindByIdNotFound() {

        Optional<Order> order =
                orderDAO.findById(
                        999999L);

        assertFalse(
                order.isPresent());
    }

    @Test
    void testFindByCustomerId() {

        List<Order> orders =
                orderDAO.findByCustomerId(
                        1L);

        assertNotNull(orders);
    }

    @Test
    void testFindAll() {

        List<Order> orders =
                orderDAO.findAll();

        assertNotNull(orders);

        assertFalse(
                orders.isEmpty());
    }

    @Test
    void testUpdateOrderStatus() {

        boolean result =
                orderDAO.updateOrderStatus(
                        1L,
                        OrderStatus.DELIVERED);

        assertTrue(result);
    }

    @Test
    void testCancelOrder() {

        boolean result =
                orderDAO.cancelOrder(
                        1L);

        assertTrue(result);
    }

    @Test
    void testCreateOrder() {

        try {

            Long orderId =
                    orderDAO.createOrder(
                            1L,
                            2500.0,
                            com.snapdeal.util
                                    .DBConnection
                                    .getConnection());

            assertNotNull(orderId);

        } catch (Exception e) {

            fail(
                    "Order creation failed");
        }
    }
}