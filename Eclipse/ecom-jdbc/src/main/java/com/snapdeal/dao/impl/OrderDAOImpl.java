package com.snapdeal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.snapdeal.dao.OrderDAO;
import com.snapdeal.enums.OrderStatus;
import com.snapdeal.model.Order;
import com.snapdeal.util.DBConnection;

public class OrderDAOImpl implements OrderDAO {

    private static final String INSERT =
            "INSERT INTO orders(customer_id,total_amount,order_date,order_status) "
                    + "VALUES(?,?,?,?)";

    private static final String FIND_BY_ID =
            "SELECT * FROM orders WHERE order_id=?";

    private static final String FIND_BY_CUSTOMER =
            "SELECT * FROM orders WHERE customer_id=?";

    private static final String FIND_ALL =
            "SELECT * FROM orders";

    private static final String UPDATE_STATUS =
            "UPDATE orders SET order_status=? WHERE order_id=?";

    @Override
    public boolean save(Order order) {

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(INSERT)) {

            ps.setLong(1, order.getCustomerId());
            ps.setDouble(2, order.getTotalAmount());

            ps.setTimestamp(3,
                    Timestamp.valueOf(
                            order.getOrderDate()));

            ps.setString(4,
                    order.getOrderStatus().name());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Long createOrder(Long customerId,
                            Double totalAmount,
                            Connection con) {

        try (PreparedStatement ps =
                     con.prepareStatement(
                             INSERT,
                             Statement.RETURN_GENERATED_KEYS)) {

            ps.setLong(1, customerId);
            ps.setDouble(2, totalAmount);

            ps.setTimestamp(3,
                    new Timestamp(
                            System.currentTimeMillis()));

            ps.setString(4,
                    OrderStatus.PLACED.name());

            int rows = ps.executeUpdate();

            if (rows > 0) {

                ResultSet rs =
                        ps.getGeneratedKeys();

                if (rs.next()) {

                    return rs.getLong(1);

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Optional<Order> findById(Long orderId) {

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(FIND_BY_ID)) {

            ps.setLong(1, orderId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Order order = mapOrder(rs);

                return Optional.of(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Order> findByCustomerId(Long customerId) {

        List<Order> orders =
                new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(
                             FIND_BY_CUSTOMER)) {

            ps.setLong(1, customerId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                orders.add(mapOrder(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    @Override
    public List<Order> findAll() {

        List<Order> orders =
                new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(FIND_ALL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                orders.add(mapOrder(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    @Override
    public boolean updateOrderStatus(
            Long orderId,
            OrderStatus orderStatus) {

        try (Connection con =
                     DBConnection.getConnection();

             PreparedStatement ps =
                     con.prepareStatement(
                             UPDATE_STATUS)) {

            ps.setString(1,
                    orderStatus.name());

            ps.setLong(2, orderId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean cancelOrder(Long orderId) {

        return updateOrderStatus(
                orderId,
                OrderStatus.CANCELLED);
    }

    private Order mapOrder(ResultSet rs)
            throws SQLException {

        Order order = new Order();

        order.setOrderId(
                rs.getLong("order_id"));

        order.setCustomerId(
                rs.getLong("customer_id"));

        order.setTotalAmount(
                rs.getDouble("total_amount"));

        order.setOrderDate(
                rs.getTimestamp(
                        "order_date")
                        .toLocalDateTime());

        order.setOrderStatus(
                OrderStatus.valueOf(
                        rs.getString(
                                "order_status")));

        return order;
    }
}