package com.snapdeal.dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.snapdeal.model.Customer;

public class CustomerDAOImplTest {

    private final CustomerDAOImpl customerDAO =
            new CustomerDAOImpl();

    @Test
    void testSaveCustomer() {

        Customer customer =
                new Customer();

        long unique =
                System.currentTimeMillis();

        customer.setCustomerName(
                "Test User");

        customer.setEmail(
                "test" + unique + "@gmail.com");

        customer.setMobile(
                "9876543210");

        customer.setAddress(
                "Bangalore");

        boolean result =
                customerDAO.save(customer);

        assertTrue(result);
    }

    @Test
    void testFindById() {

        Optional<Customer> customer =
                customerDAO.findById(1L);

        assertTrue(
                customer.isPresent());
    }

    @Test
    void testFindByEmail() {

        Optional<Customer> customer =
                customerDAO.findByEmail(
                        "daiwik@123");

        assertNotNull(customer);
    }

    @Test
    void testFindAll() {

        List<Customer> customers =
                customerDAO.findAll();

        assertNotNull(customers);

        assertFalse(
                customers.isEmpty());
    }

    @Test
    void testUpdateCustomer() {

        Optional<Customer> customerOpt =
                customerDAO.findById(1L);

        assertTrue(
                customerOpt.isPresent());

        Customer customer =
                customerOpt.get();

        customer.setAddress(
                "Updated Address");

        boolean result =
                customerDAO.update(
                        customer);

        assertTrue(result);
    }

    @Test
    void testDeleteCustomer() {

        Customer customer =
                new Customer();

        long unique =
                System.currentTimeMillis();

        customer.setCustomerName(
                "Delete User");

        customer.setEmail(
                "delete"
                        + unique
                        + "@gmail.com");

        customer.setMobile(
                "9876543211");

        customer.setAddress(
                "Test Address");

        customerDAO.save(customer);

        Optional<Customer> savedCustomer =
                customerDAO.findByEmail(
                        customer.getEmail());

        assertTrue(
                savedCustomer.isPresent());

        boolean deleted =
                customerDAO.delete(
                        savedCustomer
                                .get()
                                .getCustomerId());

        assertTrue(deleted);
    }
}