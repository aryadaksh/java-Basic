package com.snapdeal.service;

import java.util.List;

import com.snapdeal.model.Customer;

public interface CustomerService {

    boolean registerCustomer(Customer customer);

    Customer getCustomerById(Long customerId);

    Customer getCustomerByEmail(String email);

    boolean updateCustomer(Customer customer);

    boolean deleteCustomer(Long customerId);

    List<Customer> getAllCustomers();
}