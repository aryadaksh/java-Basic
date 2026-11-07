package com.snapdeal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.snapdeal.dao.CartDAO;
import com.snapdeal.model.Cart;
import com.snapdeal.util.DBConnection;

public class CartDAOImpl implements CartDAO {

    private static final String ADD_TO_CART =
            "INSERT INTO cart(customer_id, product_id, quantity) VALUES(?,?,?)";

    private static final String REMOVE_FROM_CART =
            "DELETE FROM cart WHERE cart_id=?";

    private static final String UPDATE_QUANTITY =
            "UPDATE cart SET quantity=? WHERE cart_id=?";

    private static final String VIEW_CART =
            "SELECT * FROM cart WHERE customer_id=?";

    private static final String CLEAR_CART =
            "DELETE FROM cart WHERE customer_id=?";

    private static final String CART_TOTAL =
            "SELECT SUM(p.price * c.quantity) AS total " +
            "FROM cart c " +
            "JOIN products p ON c.product_id = p.product_id " +
            "WHERE c.customer_id=?";

    @Override
    public boolean addToCart(Cart cart) {

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(ADD_TO_CART)) {

            ps.setLong(1, cart.getCustomerId());
            ps.setLong(2, cart.getProductId());
            ps.setInt(3, cart.getQuantity());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean removeFromCart(Long cartId) {

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(REMOVE_FROM_CART)) {

            ps.setLong(1, cartId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateCartQuantity(Long cartId,
                                      int quantity) {

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(UPDATE_QUANTITY)) {

            ps.setInt(1, quantity);
            ps.setLong(2, cartId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Cart> getCustomerCart(Long customerId) {

        List<Cart> cartList = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(VIEW_CART)) {

            ps.setLong(1, customerId);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    Cart cart = new Cart();

                    cart.setCartId(
                            rs.getLong("cart_id"));

                    cart.setCustomerId(
                            rs.getLong("customer_id"));

                    cart.setProductId(
                            rs.getLong("product_id"));

                    cart.setQuantity(
                            rs.getInt("quantity"));

                    cartList.add(cart);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cartList;
    }

    @Override
    public double calculateCartTotal(Long customerId) {

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(CART_TOTAL)) {

            ps.setLong(1, customerId);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return rs.getDouble("total");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0.0;
    }

    @Override
    public boolean clearCart(Long customerId) {

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(CLEAR_CART)) {

            ps.setLong(1, customerId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean clearCart(Long customerId,
                             Connection con) {

        try (PreparedStatement ps =
                     con.prepareStatement(CLEAR_CART)) {

            ps.setLong(1, customerId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}