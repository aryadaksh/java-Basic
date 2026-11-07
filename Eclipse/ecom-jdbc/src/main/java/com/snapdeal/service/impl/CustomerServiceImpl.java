package com.snapdeal.service.impl;

import java.util.List;

import com.snapdeal.dao.CustomerDAO;
import com.snapdeal.dao.impl.CustomerDAOImpl;
import com.snapdeal.exception.CustomerNotFoundException;
import com.snapdeal.exception.DuplicateCustomerException;
import com.snapdeal.exception.InvalidEmailException;
import com.snapdeal.model.Customer;
import com.snapdeal.service.CustomerService;

public class CustomerServiceImpl
        implements CustomerService {

    private CustomerDAO customerDAO =
            new CustomerDAOImpl();

    @Override
    public boolean registerCustomer(
            Customer customer) {

        if (customer == null) {

            throw new CustomerNotFoundException(
                    "Customer data is null");
        }

        if (customer.getEmail() == null
                || !customer.getEmail().matches(
                        "^[A-Za-z0-9+_.-]+@(.+)$")) {

            throw new InvalidEmailException(
                    "Invalid Email Format");
        }

        Customer existingCustomer =
                customerDAO.findByEmail(
                        customer.getEmail())
                        .orElse(null);

        if (existingCustomer != null) {

            throw new DuplicateCustomerException(
                    "Customer already exists with email : "
                            + customer.getEmail());
        }

        return customerDAO.save(customer);
    }

    @Override
    public Customer getCustomerById(
            Long customerId) {

        return customerDAO
                .findById(customerId)
                .orElseThrow(() ->
                        new CustomerNotFoundException(
                                "Customer not found with id : "
                                        + customerId));
    }

    @Override
    public Customer getCustomerByEmail(
            String email) {

        return customerDAO
                .findByEmail(email)
                .orElseThrow(() ->
                        new CustomerNotFoundException(
                                "Customer not found with email : "
                                        + email));
    }

    @Override
    public boolean updateCustomer(
            Customer customer) {

        customerDAO
                .findById(
                        customer.getCustomerId())
                .orElseThrow(() ->
                        new CustomerNotFoundException(
                                "Customer Not Found"));

        return customerDAO.update(customer);
    }

    @Override
    public boolean deleteCustomer(
            Long customerId) {

        customerDAO
                .findById(customerId)
                .orElseThrow(() ->
                        new CustomerNotFoundException(
                                "Customer Not Found"));

        return customerDAO.delete(customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {

        return customerDAO.findAll();
    }
}