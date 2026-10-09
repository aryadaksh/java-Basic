package com.test;

import java.util.List;

import com.exception.InsufficientStockException;
import com.exception.ProductNotFoundException;
import com.model.Order;
import com.model.Product;
import com.repository.OrderRepository;
import com.repository.ProductRepository;
import com.service.CartService;
import com.service.OrderService;

public class CartOrdertest {
	


	
	    public static void main(String[] args) {
	        // Setup repositories and services
	        ProductRepository productRepo = new ProductRepository();
	        OrderRepository orderRepo = new OrderRepository();
	        CartService cartService = new CartService();
	        OrderService orderService = new OrderService(orderRepo, productRepo, cartService);

	        // Admin adds products
	        Product iphone = new Product("iPhone 16", "Mobile", 80000, 10, "Apple");
	        Product laptop = new Product("Dell XPS", "Laptop", 120000, 5, "Dell");
	        productRepo.addProduct(iphone);
	        productRepo.addProduct(laptop);

	        // Customer adds items to cart
	        int customerId = 101; // assume registered customer
	        try {
	            cartService.addToCart(customerId, iphone, 2);
	            cartService.addToCart(customerId, laptop, 1);
	        } catch (InsufficientStockException e) {
	            System.out.println(e.getMessage());
	        }

	        // View cart
	        System.out.println("Cart Items:");
	        cartService.viewCart(customerId).forEach(System.out::println);
	        System.out.println("Cart Total: Rs." + cartService.calculateTotal(customerId));

	        // Place order
	        try {
	            Order order = orderService.placeOrder(customerId);
	            System.out.println("Order placed successfully: " + order);
	        } catch (InsufficientStockException | ProductNotFoundException e) {
	            System.out.println(e.getMessage());
	        }

	        System.out.println("My Orders:");
	        List<Order> myOrders = orderService.viewOrdersByCustomer(customerId);
	        if (myOrders.isEmpty()) {
	            System.out.println("No orders found for customer " + customerId);
	        } else {
	            myOrders.forEach(System.out::println);
	        }

	    }
	}




