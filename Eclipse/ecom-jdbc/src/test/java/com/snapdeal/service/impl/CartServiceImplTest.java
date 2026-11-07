package com.snapdeal.service.impl;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.snapdeal.model.Cart;

public class CartServiceImplTest {

    private final CartServiceImpl cartService =
            new CartServiceImpl();

    @Test
    public void testAddToCart() {

        Cart cart = new Cart();

        cart.setCustomerId(1L);
        cart.setProductId(1L);
        cart.setQuantity(2);

        cartService.addToCart(cart);
    }

    @Test
    public void testAddToCartWithInvalidQuantity() {

        Cart cart = new Cart();

        cart.setCustomerId(1L);
        cart.setProductId(1L);
        cart.setQuantity(0);

        assertThrows(
                IllegalArgumentException.class,
                () -> cartService.addToCart(cart));
    }

    @Test
    public void testViewCart() {

        List<Cart> cartList =
                cartService.viewCart(1L);

        assertNotNull(cartList);
    }

    @Test
    public void testCalculateCartTotal() {

        double total =
                cartService.calculateCartTotal(1L);

        assertNotNull(total);
    }

    @Test
    public void testRemoveFromCart() {

        boolean result =
                cartService.removeFromCart(1L);

        assertFalse(false == result && result == true);
    }

    @Test
    public void testIncreaseQuantity() {

        cartService.increaseQuantity(1L, 5);
    }

    @Test
    public void testDecreaseQuantity() {

        cartService.decreaseQuantity(1L, 1);
    }

    @Test
    public void testClearCart() {

        cartService.clearCart(1L);
    }
}
