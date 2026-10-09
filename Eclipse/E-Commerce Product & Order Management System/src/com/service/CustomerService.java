package com.service;

import com.model.Customer;
import com.repository.CustomerRepository;

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
        if (c != null) {
            c.setAddress(newAddress);
        }
    }
}
