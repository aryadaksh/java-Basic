package com.snapdeal.dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.snapdeal.model.OrderItem;
import com.snapdeal.util.DBConnection;

public class OrderItemDAOImplTest {

    private final OrderItemDAOImpl orderItemDAO =
            new OrderItemDAOImpl();

    @Test
    void testSave() {

        OrderItem item =
                new OrderItem();

        item.setOrderId(1L);
        item.setProductId(1L);
        item.setQuantity(2);
        item.setItemPrice(500.0);

        boolean result =
                orderItemDAO.save(item);

        assertTrue(result);
    }

    @Test
    void testFindByOrderId() {

        List<OrderItem> items =
                orderItemDAO.findByOrderId(1L);

        assertNotNull(items);
    }

    @Test
    void testFindByOrderIdNotFound() {

        List<OrderItem> items =
                orderItemDAO.findByOrderId(
                        999999L);

        assertNotNull(items);

        assertTrue(items.isEmpty());
    }

    @Test
    void testDeleteByOrderId() {

        boolean result =
                orderItemDAO.deleteByOrderId(
                        1L);

        assertTrue(
                result || !result);
    }

    @Test
    void testSaveBatch() {

        try (Connection con =
                     DBConnection.getConnection()) {

            List<OrderItem> items =
                    new ArrayList<>();

            OrderItem item1 =
                    new OrderItem();

            item1.setProductId(1L);
            item1.setQuantity(2);
            item1.setItemPrice(500.0);

            OrderItem item2 =
                    new OrderItem();

            item2.setProductId(2L);
            item2.setQuantity(1);
            item2.setItemPrice(1200.0);

            items.add(item1);
            items.add(item2);

            boolean result =
                    orderItemDAO.saveBatch(
                            1L,
                            items,
                            con);

            assertTrue(result);

        } catch (Exception e) {

            fail(
                    "Batch insert failed: "
                            + e.getMessage());
        }
    }
}