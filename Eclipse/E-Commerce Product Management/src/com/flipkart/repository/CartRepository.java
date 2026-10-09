package com.flipkart.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flipkart.main.CartItem;

public class CartRepository {
	private Map<Integer, List<CartItem>> carts = new HashMap<>();

	public void addToCart(int customerId, CartItem item) {
		carts.computeIfAbsent(customerId, k -> new ArrayList<>()).add(item);
	}

	public List<CartItem> getCart(int customerId) {
		return carts.getOrDefault(customerId, new ArrayList<>());
	}

	public void clearCart(int customerId) {
		carts.remove(customerId);
	}
}
