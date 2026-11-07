package com.snapdeal.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.snapdeal.model.Customer;

public class CustomerServiceImplTest {

    private final CustomerServiceImpl customerService =
            new CustomerServiceImpl();

    @Test
    public void testRegisterCustomer() {

        Customer customer =
                new Customer();

        customer.setCustomerName(
                "Test Customer");

        customer.setEmail(
                "testcustomer@gmail.com");

        customer.setMobile(
                "9876543210");

        customer.setAddress(
                "Bangalore");

        boolean result =
                customerService.registerCustomer(
                        customer);

        assertTrue(result);
    }

    @Test
    public void testRegisterCustomerWithNull() {

        assertThrows(
                IllegalArgumentException.class,
                () -> customerService.registerCustomer(
                        null));
    }

    @Test
    public void testGetCustomerById() {

        Customer customer =
                customerService.getCustomerById(
                        1L);

        assertNotNull(customer);
    }

    @Test
    public void testGetCustomerByEmail() {

        Customer customer =
                customerService.getCustomerByEmail(
                        "testcustomer@gmail.com");

        assertNotNull(customer);
    }

    @Test
    public void testGetAllCustomers() {

        List<Customer> customers =
                customerService.getAllCustomers();

        assertNotNull(customers);
    }

    @Test
    public void testUpdateCustomer() {

        Customer customer =
                customerService.getCustomerById(
                        1L);

        if (customer != null) {

            customer.setAddress(
                    "Updated Address");

            boolean result =
                    customerService.updateCustomer(
                            customer);

            assertTrue(result);
        }
    }

    @Test
    public void testDeleteCustomer() {

        Customer customer =
                new Customer();

        customer.setCustomerName(
                "Delete Test");

        customer.setEmail(
                "delete@test.com");

        customer.setMobile(
                "9999999999");

        customer.setAddress(
                "Test Address");

        customerService.registerCustomer(
                customer);

        Customer savedCustomer =
                customerService.getCustomerByEmail(
                        "delete@test.com");

        assertNotNull(savedCustomer);

        boolean result =
                customerService.deleteCustomer(
                        savedCustomer.getCustomerId());

        assertTrue(result);
    }
}