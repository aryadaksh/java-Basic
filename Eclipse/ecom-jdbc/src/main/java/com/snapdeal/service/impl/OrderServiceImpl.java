package com.snapdeal.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.snapdeal.dao.CartDAO;
import com.snapdeal.dao.OrderDAO;
import com.snapdeal.dao.OrderItemDAO;
import com.snapdeal.dao.ProductDAO;

import com.snapdeal.dao.impl.CartDAOImpl;
import com.snapdeal.dao.impl.OrderDAOImpl;
import com.snapdeal.dao.impl.OrderItemDAOImpl;
import com.snapdeal.dao.impl.ProductDAOImpl;

import com.snapdeal.exception.DatabaseOperationException;
import com.snapdeal.exception.EmptyCartException;
import com.snapdeal.exception.OrderNotFoundException;
import com.snapdeal.exception.ProductOutOfStockException;

import com.snapdeal.model.Cart;
import com.snapdeal.model.Order;
import com.snapdeal.model.OrderItem;
import com.snapdeal.model.Product;

import com.snapdeal.service.OrderService;
import com.snapdeal.util.DBConnection;

public class OrderServiceImpl
        implements OrderService {

    private OrderItemDAO orderItemDAO =
            new OrderItemDAOImpl();

    private ProductDAO productDAO =
            new ProductDAOImpl();

    private CartDAO cartDAO =
            new CartDAOImpl();

    private OrderDAO orderDAO =
            new OrderDAOImpl();

    private List<OrderItem> orderItems =
            new ArrayList<>();

    @Override
    public boolean placeOrder(
            Long customerId) {

        Connection con = null;

        try {

            con = DBConnection.getConnection();

            con.setAutoCommit(false);

            List<Cart> cartItems =
                    cartDAO.getCustomerCart(
                            customerId);

            if (cartItems.isEmpty()) {

                throw new EmptyCartException(
                        "Cart is empty");
            }

            double totalAmount =
                    cartDAO.calculateCartTotal(
                            customerId);

            Long orderId =
                    orderDAO.createOrder(
                            customerId,
                            totalAmount,
                            con);

            orderItems.clear();

            for (Cart cart : cartItems) {

                Product product =
                        productDAO.findById(
                                cart.getProductId())
                                .orElseThrow(() ->
                                        new ProductOutOfStockException(
                                                "Product Not Found"));

                if (product.getQuantity()
                        < cart.getQuantity()) {

                    throw new ProductOutOfStockException(
                            "Insufficient stock for Product Id : "
                                    + cart.getProductId());
                }

                OrderItem item =
                        new OrderItem();

                item.setProductId(
                        cart.getProductId());

                item.setQuantity(
                        cart.getQuantity());

                orderItems.add(item);
            }

            orderItemDAO.saveBatch(
                    orderId,
                    orderItems,
                    con);

            for (Cart cart : cartItems) {

                productDAO.reduceStock(
                        cart.getProductId(),
                        cart.getQuantity(),
                        con);
            }

            cartDAO.clearCart(
                    customerId,
                    con);

            con.commit();

            return true;

        } catch (Exception e) {

            try {

                if (con != null) {

                    con.rollback();
                }

            } catch (Exception ex) {

                throw new DatabaseOperationException(
                        "Rollback Failed",
                        ex);
            }

            throw new DatabaseOperationException(
                    "Failed To Place Order",
                    e);

        } finally {

            try {

                if (con != null) {

                    con.setAutoCommit(true);
                }

            } catch (Exception ex) {

                ex.printStackTrace();
            }
        }
    }

    @Override
    public Order getOrderById(
            Long orderId) {

        return orderDAO
                .findById(orderId)
                .orElseThrow(() ->
                        new OrderNotFoundException(
                                "Order Not Found : "
                                        + orderId));
    }

    @Override
    public List<Order> getCustomerOrders(
            Long customerId) {

        List<Order> orders =
                orderDAO.findByCustomerId(
                        customerId);

        if (orders.isEmpty()) {

            throw new OrderNotFoundException(
                    "No Orders Found");
        }

        return orders;
    }

    @Override
    public List<Order> getAllOrders() {

        List<Order> orders =
                orderDAO.findAll();

        if (orders.isEmpty()) {

            throw new OrderNotFoundException(
                    "No Orders Available");
        }

        return orders;
    }

    @Override
    public boolean cancelOrder(
            Long orderId) {

        orderDAO.findById(orderId)
                .orElseThrow(() ->
                        new OrderNotFoundException(
                                "Order Not Found"));

        return orderDAO.cancelOrder(
                orderId);
    }

    @Override
    public List<Order> getOrderHistory(
            Long customerId) {

        List<Order> orders =
                orderDAO.findByCustomerId(
                        customerId);

        if (orders.isEmpty()) {

            throw new OrderNotFoundException(
                    "No Order History Found");
        }

        return orders;
    }
}