package com.flipkart.service;

import java.util.ArrayList;
import java.util.List;

import com.flipkart.main.Customer;
import com.flipkart.main.Order;
import com.flipkart.main.Product;
import com.flipkart.repository.CustomerRepository;
import com.flipkart.repository.OrderRepository;
import com.flipkart.repository.ProductRepository;

public class AdminService {
	private ProductRepository productRepo;
	private CustomerRepository customerRepo;
	private OrderRepository orderRepo;

	public AdminService(ProductRepository productRepo, CustomerRepository customerRepo, OrderRepository orderRepo) {
		this.productRepo = productRepo;
		this.customerRepo = customerRepo;
		this.orderRepo = orderRepo;
	}

	public void addProduct(Product product) {
		productRepo.addProduct(product);
	}

	public void updateProduct(Product product) {
		productRepo.updateProduct(product);
	}

	public void deleteProduct(int id) {
		productRepo.deleteProduct(id);
	}

	public List<Customer> viewAllCustomers() {
		return new ArrayList<>(customerRepo.getAllCustomers());
	}

	public List<Order> viewAllOrders() {
		return orderRepo.getAllOrders();
	}
}
