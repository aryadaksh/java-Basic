package com.test;

import com.model.Customer;
import com.model.Order;
import com.model.Product;
import com.repository.CustomerRepository;
import com.repository.OrderRepository;
import com.repository.ProductRepository;
import com.service.AdminService;
import com.service.CartService;
import com.service.CustomerService;
import com.service.OrderService;

public class AdminCustomer{


    public static void main(String[] args) {
        // Setup repos
        ProductRepository productRepo = new ProductRepository();
        CustomerRepository customerRepo = new CustomerRepository();
        OrderRepository orderRepo = new OrderRepository();

        // Services
        AdminService adminService = new AdminService(productRepo, customerRepo, orderRepo);
        CustomerService customerService = new CustomerService(customerRepo);
        CartService cartService = new CartService();
        OrderService orderService = new OrderService(orderRepo, productRepo, cartService);

        // Admin adds product
        Product iphone = new Product("iPhone 16", "Mobile", 80000, 10, "Apple");
        adminService.addProduct(iphone);

        // Customer registers
        Customer cust = new Customer(101, "Daksh", "daksh@example.com", "9876543210", "Bengaluru");
        customerService.registerCustomer(cust);

        // Customer adds to cart + places order
        try {
            cartService.addToCart(cust.getCustomerId(), iphone, 2);
            Order order = orderService.placeOrder(cust.getCustomerId());
            System.out.println("Order placed: " + order);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Admin views all orders
        System.out.println("Admin sees orders:");
        adminService.viewAllOrders().forEach(System.out::println);
    }
}
