package com.snapdeal.dao;

import com.snapdeal.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO {

	boolean save(Customer customer);

	boolean update(Customer customer);

	boolean delete(Long customerId);

	Optional<Customer> findById(Long customerId);

	Optional<Customer> findByEmail(String email);

	List<Customer> findAll();
}
