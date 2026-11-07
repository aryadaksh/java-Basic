package com.snapdeal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.snapdeal.dao.OrderItemDAO;
import com.snapdeal.model.OrderItem;
import com.snapdeal.util.DBConnection;

public class OrderItemDAOImpl implements OrderItemDAO {

    private static final String INSERT =
            "INSERT INTO order_items(order_id, product_id, quantity, item_price) "
                    + "VALUES(?,?,?,?)";

    private static final String FIND_BY_ORDER_ID =
            "SELECT * FROM order_items WHERE order_id=?";

    private static final String DELETE_BY_ORDER_ID =
            "DELETE FROM order_items WHERE order_id=?";

    @Override
    public boolean save(OrderItem orderItem) {

        try (Connection con =
                     DBConnection.getConnection();

             PreparedStatement ps =
                     con.prepareStatement(INSERT)) {

            ps.setLong(1, orderItem.getOrderId());
            ps.setLong(2, orderItem.getProductId());
            ps.setInt(3, orderItem.getQuantity());
            ps.setDouble(4, orderItem.getItemPrice());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean saveBatch(Long orderId,
                             List<OrderItem> orderItems,
                             Connection con) {

        try (PreparedStatement ps =
                     con.prepareStatement(INSERT)) {

            for (OrderItem item : orderItems) {

                ps.setLong(1, orderId);
                ps.setLong(2, item.getProductId());
                ps.setInt(3, item.getQuantity());
                ps.setDouble(4, item.getItemPrice());

                ps.addBatch();
            }

            int[] results = ps.executeBatch();

            return results.length > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<OrderItem> findByOrderId(Long orderId) {

        List<OrderItem> orderItems =
                new ArrayList<>();

        try (Connection con =
                     DBConnection.getConnection();

             PreparedStatement ps =
                     con.prepareStatement(
                             FIND_BY_ORDER_ID)) {

            ps.setLong(1, orderId);

            try (ResultSet rs =
                         ps.executeQuery()) {

                while (rs.next()) {

                    OrderItem item =
                            new OrderItem();

                    item.setOrderItemId(
                            rs.getLong(
                                    "order_item_id"));

                    item.setOrderId(
                            rs.getLong(
                                    "order_id"));

                    item.setProductId(
                            rs.getLong(
                                    "product_id"));

                    item.setQuantity(
                            rs.getInt(
                                    "quantity"));

                    item.setItemPrice(
                            rs.getDouble(
                                    "item_price"));

                    orderItems.add(item);
                }
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return orderItems;
    }

    @Override
    public boolean deleteByOrderId(Long orderId) {

        try (Connection con =
                     DBConnection.getConnection();

             PreparedStatement ps =
                     con.prepareStatement(
                             DELETE_BY_ORDER_ID)) {

            ps.setLong(1, orderId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }
}