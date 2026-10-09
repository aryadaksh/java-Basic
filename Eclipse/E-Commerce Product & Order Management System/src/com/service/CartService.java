package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.exception.InsufficientStockException;
import com.model.CartItem;
import com.model.Product;

public class CartService {

	 private Map<Integer, List<CartItem>> carts = new HashMap<>();

	    public void addToCart(int customerId, Product product, int qty) throws InsufficientStockException {
	        if (product.getQuantity() < qty) {
	            throw new InsufficientStockException("Not enough stock for " + product.getProductName());
	        }

	        List<CartItem> cart = carts.getOrDefault(customerId, new ArrayList<>());
	        cart.add(new CartItem(product.getProductId(), product.getProductName(), product.getPrice(), qty));
	        carts.put(customerId, cart);
	    }

	    public void removeFromCart(int customerId, int productId) {
	        List<CartItem> cart = carts.getOrDefault(customerId, new ArrayList<>());
	        cart.removeIf(item -> item.getProductId() == productId);
	    }

	    public double calculateTotal(int customerId) {
	        return carts.getOrDefault(customerId, new ArrayList<>())
	                    .stream()
	                    .mapToDouble(CartItem::getTotalPrice)
	                    .sum();
	    }

	    public List<CartItem> viewCart(int customerId) {
	        return carts.getOrDefault(customerId, new ArrayList<>());
	    }

	    public void clearCart(int customerId) {
	        carts.remove(customerId);
    

}
}
