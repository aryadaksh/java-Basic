package com.snapdeal.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.snapdeal.model.Order;

public class OrderServiceImplTest {

    private final OrderServiceImpl orderService =
            new OrderServiceImpl();

    @Test
    public void testGetOrderById() {

        Order order =
                orderService.getOrderById(1L);

        assertNotNull(order);
    }

    @Test
    public void testGetCustomerOrders() {

        List<Order> orders =
                orderService.getCustomerOrders(1L);

        assertNotNull(orders);
    }

    @Test
    public void testGetAllOrders() {

        List<Order> orders =
                orderService.getAllOrders();

        assertNotNull(orders);
    }

    @Test
    public void testOrderHistory() {

        List<Order> orders =
                orderService.getOrderHistory(1L);

        assertNotNull(orders);
    }

    @Test
    public void testCancelOrder() {

        boolean result =
                orderService.cancelOrder(1L);

        assertTrue(result);
    }

    @Test
    public void testPlaceOrder() {

        boolean result =
                orderService.placeOrder(1L);

        assertTrue(result);
    }
}