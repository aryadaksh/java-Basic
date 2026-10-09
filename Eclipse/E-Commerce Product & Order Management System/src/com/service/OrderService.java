package com.service;

import java.util.List;

import com.exception.InsufficientStockException;
import com.exception.ProductNotFoundException;
import com.model.CartItem;
import com.model.Order;
import com.model.Product;
import com.repository.OrderRepository;
import com.repository.ProductRepository;

public class OrderService {
	
	 private OrderRepository orderRepo;
	    private ProductRepository productRepo;
	    private CartService cartService;

	    public OrderService(OrderRepository orderRepo, ProductRepository productRepo, CartService cartService) {
	        this.orderRepo = orderRepo;
	        this.productRepo = productRepo;
	        this.cartService = cartService;
	    }

	    public Order placeOrder(int customerId) throws InsufficientStockException, ProductNotFoundException {
	        List<CartItem> cart = cartService.viewCart(customerId);
	        if (cart.isEmpty()) {
	            throw new InsufficientStockException("Cart is empty!");
	        }

	        // Validate stock
	        for (CartItem item : cart) {
	            Product product = productRepo.getProductById(item.getProductId());
	            if (product.getQuantity() < item.getQuantity()) {
	                throw new InsufficientStockException("Not enough stock for " + product.getProductName());
	            }
	            product.setQuantity(product.getQuantity() - item.getQuantity()); // reduce stock
	        }

	        // Create order
	        Order order = new Order(customerId, cart);
	        orderRepo.saveOrder(order);

	        // Clear cart
	        cartService.clearCart(customerId);

	        return order;
	    }

	    public void cancelOrder(int orderId) {
	        orderRepo.getAllOrders().stream()
	                 .filter(o -> o.getOrderId() == orderId)
	                 .findFirst()
	                 .ifPresent(order -> order.setOrderStatus("CANCELLED"));
	    }

	    public List<Order> viewOrdersByCustomer(int customerId) {
	        return orderRepo.getOrdersByCustomer(customerId);
	    }

}
