package com.flipkart.service;

import com.flipkart.main.Customer;
import com.flipkart.main.Product;
import com.flipkart.repository.CustomerRepository;

public class CustomerService {
	private CustomerRepository repo;

	public CustomerService(CustomerRepository repo) {
		this.repo = repo;
	}

	public void registerCustomer(Customer customer) {
		repo.addCustomer(customer);
	}

	public Customer viewCustomer(int id) {
		return repo.getCustomerById(id);
	}

	public void updateAddress(int id, String newAddress) {
		Customer c = repo.getCustomerById(id);
		if (c != null)
			c.setAddress(newAddress);
	}

	public Iterable<Product> viewAllCustomers() {
		
		return null;
	}
}
