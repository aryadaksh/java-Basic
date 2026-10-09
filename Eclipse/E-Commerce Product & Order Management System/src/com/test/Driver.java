package com.test;

import com.exception.InsufficientStockException;
import com.exception.ProductNotFoundException;
import com.model.*;
import com.repository.*;
import com.service.*;
import java.util.*;

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Setup repositories
        ProductRepository productRepo = new ProductRepository();
        CustomerRepository customerRepo = new CustomerRepository();
        OrderRepository orderRepo = new OrderRepository();

        // Setup services
        AdminService adminService = new AdminService(productRepo, customerRepo, orderRepo);
        CustomerService customerService = new CustomerService(customerRepo);
        CartService cartService = new CartService();
        OrderService orderService = new OrderService(orderRepo, productRepo, cartService);

        while (true) {
            System.out.println("\n===== E-Commerce System =====");
            System.out.println("1. Admin Menu");
            System.out.println("2. Customer Menu");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    showAdminMenu(sc, adminService, productRepo);
                    break;
                case 2:
                    showCustomerMenu(sc, customerService, cartService, orderService, productRepo);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Admin Menu
    private static void showAdminMenu(Scanner sc, AdminService adminService, ProductRepository productRepo) {
        System.out.println("\n=== Admin Menu ===");
        System.out.println("1. Add Product");
        System.out.println("2. View All Products");
        System.out.println("3. View All Customers");
        System.out.println("4. View All Orders");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter product name: ");
                String name = sc.next();
                System.out.print("Enter category: ");
                String category = sc.next();
                System.out.print("Enter price: ");
                double price = sc.nextDouble();
                System.out.print("Enter quantity: ");
                int qty = sc.nextInt();
                System.out.print("Enter brand: ");
                String brand = sc.next();

                Product p = new Product(name, category, price, qty, brand);
                adminService.addProduct(p);
                System.out.println("Product added!");
                break;

            case 2:
                productRepo.getAllProducts().forEach(System.out::println);
                break;

            case 3:
                adminService.viewAllCustomers().forEach(System.out::println);
                break;

            case 4:
                adminService.viewAllOrders().forEach(System.out::println);
                break;

            default:
                System.out.println("Invalid choice!");
        }
    }

    // Customer Menu
    private static void showCustomerMenu(Scanner sc, CustomerService customerService,
                                         CartService cartService, OrderService orderService,
                                         ProductRepository productRepo) {
        System.out.println("\n=== Customer Menu ===");
        System.out.println("1. Register Customer");
        System.out.println("2. View Products");
        System.out.println("3. Add to Cart");
        System.out.println("4. View Cart");
        System.out.println("5. Place Order");
        System.out.println("6. View My Orders");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        int customerId = 101; // fixed for demo

        switch (choice) {
            case 1:
                Customer c = new Customer(customerId, "Daksh", "daksh@example.com", "9876543210", "Bengaluru");
                customerService.registerCustomer(c);
                System.out.println("Customer registered!");
                break;

            case 2:
                productRepo.getAllProducts().forEach(System.out::println);
                break;

            case 3:
                System.out.print("Enter productId: ");
                int pid = sc.nextInt();
                System.out.print("Enter quantity: ");
                int qty = sc.nextInt();
			Product prod;
			try {
				prod = productRepo.getProductById(pid);
			} catch (ProductNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                if (prod != null) {
                    try {
						cartService.addToCart(customerId, prod, qty);
					} catch (InsufficientStockException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    System.out.println("Added to cart!");
                } else {
                    System.out.println("Product not found!");
                }
                break;

            case 4:
                cartService.viewCart(customerId).forEach(System.out::println);
                System.out.println("Cart Total: Rs." + cartService.calculateTotal(customerId));
                break;

            case 5:
                try {
                    Order order = orderService.placeOrder(customerId);
                    System.out.println("Order placed: " + order);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 6:
                orderService.viewOrdersByCustomer(customerId).forEach(System.out::println);
                break;

            default:
                System.out.println("Invalid choice!");
        }
    }
}
