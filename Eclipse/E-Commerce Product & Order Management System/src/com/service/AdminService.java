package com.service;

import com.model.Product;
import com.model.Customer;
import com.model.Order;
import com.repository.ProductRepository;
import com.repository.CustomerRepository;
import com.repository.OrderRepository;
import java.util.*;

public class AdminService {
    private ProductRepository productRepo;
    private CustomerRepository customerRepo;
    private OrderRepository orderRepo;

    public AdminService(ProductRepository productRepo, CustomerRepository customerRepo, OrderRepository orderRepo) {
        this.productRepo = productRepo;
        this.customerRepo = customerRepo;
        this.orderRepo = orderRepo;
    }

    // Product management
    public void addProduct(Product product) {
        productRepo.addProduct(product);
    }

    public void updateProduct(Product product) {
        productRepo.updateProduct(product);
    }

    public void deleteProduct(int id) {
        productRepo.deleteProduct(id);
    }

    // Customer management
    public List<Customer> viewAllCustomers() {
        return new ArrayList<>(customerRepo.getAllCustomers());
    }

    // Order management
    public List<Order> viewAllOrders() {
        return orderRepo.getAllOrders();
    }
}
