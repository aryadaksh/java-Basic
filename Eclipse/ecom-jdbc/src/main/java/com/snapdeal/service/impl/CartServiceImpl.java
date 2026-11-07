package com.snapdeal.service.impl;

import java.util.List;

import com.snapdeal.dao.CartDAO;
import com.snapdeal.dao.ProductDAO;

import com.snapdeal.dao.impl.CartDAOImpl;
import com.snapdeal.dao.impl.ProductDAOImpl;

import com.snapdeal.exception.CartNotFoundException;
import com.snapdeal.exception.InsufficientStockException;
import com.snapdeal.exception.ProductNotFoundException;
import com.snapdeal.exception.ProductOutOfStockException;

import com.snapdeal.model.Cart;
import com.snapdeal.model.Product;

import com.snapdeal.service.CartService;

public class CartServiceImpl
        implements CartService {

    private CartDAO cartDAO =
            new CartDAOImpl();

    private ProductDAO productDAO =
            new ProductDAOImpl();

    @Override
    public boolean addToCart(
            Cart cart) {

        Product product =
                productDAO
                        .findById(
                                cart.getProductId())
                        .orElseThrow(() ->
                                new ProductNotFoundException(
                                        "Product Not Found"));

        if (product.getQuantity() == 0) {

            throw new ProductOutOfStockException(
                    "Product Out Of Stock");
        }

        if (cart.getQuantity() >
                product.getQuantity()) {

            throw new InsufficientStockException(
                    "Requested Quantity Not Available");
        }

        return cartDAO.addToCart(cart);
    }

    @Override
    public boolean removeFromCart(
            Long cartId) {

        boolean removed =
                cartDAO.removeFromCart(
                        cartId);

        if (!removed) {

            throw new CartNotFoundException(
                    "Cart Item Not Found");
        }

        return true;
    }

    @Override
    public boolean increaseQuantity(
            Long cartId,
            int quantity) {

        if (quantity <= 0) {

            throw new InsufficientStockException(
                    "Quantity Must Be Greater Than Zero");
        }

        return cartDAO.updateCartQuantity(
                cartId,
                quantity);
    }

    @Override
    public boolean decreaseQuantity(
            Long cartId,
            int quantity) {

        if (quantity <= 0) {

            throw new InsufficientStockException(
                    "Quantity Must Be Greater Than Zero");
        }

        return cartDAO.updateCartQuantity(
                cartId,
                quantity);
    }

    @Override
    public List<Cart> viewCart(
            Long customerId) {

        List<Cart> cartItems =
                cartDAO.getCustomerCart(
                        customerId);

        if (cartItems.isEmpty()) {

            throw new CartNotFoundException(
                    "Cart Is Empty");
        }

        return cartItems;
    }

    @Override
    public double calculateCartTotal(
            Long customerId) {

        List<Cart> cartItems =
                cartDAO.getCustomerCart(
                        customerId);

        if (cartItems.isEmpty()) {

            throw new CartNotFoundException(
                    "Cart Is Empty");
        }

        return cartDAO.calculateCartTotal(
                customerId);
    }

    @Override
    public boolean clearCart(
            Long customerId) {

        List<Cart> cartItems =
                cartDAO.getCustomerCart(
                        customerId);

        if (cartItems.isEmpty()) {

            throw new CartNotFoundException(
                    "Cart Is Empty");
        }

        return cartDAO.clearCart(
                customerId);
    }
}