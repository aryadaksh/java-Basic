package com.flipkart.service;

import java.util.List;

import com.flipkart.exception.InsufficientStockException;
import com.flipkart.exception.InvalidOrderException;
import com.flipkart.exception.ProductNotFoundException;
import com.flipkart.main.CartItem;
import com.flipkart.main.Order;
import com.flipkart.main.Product;
import com.flipkart.repository.OrderRepository;
import com.flipkart.repository.ProductRepository;

public class OrderService {
	private OrderRepository orderRepo;
	private ProductRepository productRepo;
	private CartService cartService;

	public OrderService(OrderRepository orderRepo, ProductRepository productRepo, CartService cartService) {
		this.orderRepo = orderRepo;
		this.productRepo = productRepo;
		this.cartService = cartService;
	}

	public Order placeOrder(int customerId) throws ProductNotFoundException, InsufficientStockException {
		List<CartItem> cart = cartService.viewCart(customerId);
		if (cart.isEmpty())
			throw new InvalidOrderException("Cart is empty!");

		for (CartItem item : cart) {
			Product product = productRepo.getProductById(item.getProductId());
			if (product == null)
				throw new ProductNotFoundException("Product with ID " + item.getProductId() + " not found.");
			if (product.getQuantity() < item.getQuantity())
				throw new InsufficientStockException("Not enough stock for " + product.getProductName());
			product.setQuantity(product.getQuantity() - item.getQuantity());
		}

		Order order = new Order(customerId, cart);
		orderRepo.saveOrder(order);
		cartService.clearCart(customerId);
		return order;
	}

	public List<Order> viewOrdersByCustomer(int customerId) {
		return orderRepo.getOrdersByCustomer(customerId);
	}

	public void cancelOrder(int orderId) {
		for (Order o : orderRepo.getAllOrders()) {
			if (o.getOrderId() == orderId) {
				o.setOrderStatus("CANCELLED");
				return;
			}
		}
	}

	public List<Order> viewAllOrders() {
		return orderRepo.getAllOrders();
	}
}
