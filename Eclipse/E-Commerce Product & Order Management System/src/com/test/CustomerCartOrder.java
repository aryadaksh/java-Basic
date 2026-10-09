package com.test;

import com.model.Customer;
import com.model.Order;
import com.model.Product;
import com.repository.CustomerRepository;
import com.repository.OrderRepository;
import com.repository.ProductRepository;
import com.service.CartService;
import com.service.CustomerService;
import com.service.OrderService;

public class CustomerCartOrder {
	
	
	    public static void main(String[] args) {
	        // Setup
	        ProductRepository productRepo = new ProductRepository();
	        OrderRepository orderRepo = new OrderRepository();
	        CustomerRepository customerRepo = new CustomerRepository();

	        CartService cartService = new CartService();
	        OrderService orderService = new OrderService(orderRepo, productRepo, cartService);
	        CustomerService customerService = new CustomerService(customerRepo);

	        // Admin adds products
	        Product iphone = new Product("iPhone 16", "Mobile", 80000, 10, "Apple");
	        productRepo.addProduct(iphone);

	        // Customer registers
	        Customer cust = new Customer(101, "Daksh", "daksh@example.com", "9876543210", "Bengaluru");
	        customerService.registerCustomer(cust);

	        // Customer adds to cart
	        try {
	            cartService.addToCart(cust.getCustomerId(), iphone, 2);
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }

	        // Place order
	        try {
	            Order order = orderService.placeOrder(cust.getCustomerId());
	            System.out.println("Order placed: " + order);
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }

	        // View orders
	        orderService.viewOrdersByCustomer(cust.getCustomerId()).forEach(System.out::println);
	    }
	}



