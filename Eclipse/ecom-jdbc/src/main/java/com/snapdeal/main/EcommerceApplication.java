package com.snapdeal.main;

import java.util.Scanner;

import com.snapdeal.service.CartService;
import com.snapdeal.service.CustomerService;
import com.snapdeal.service.OrderService;
import com.snapdeal.service.ProductService;
import com.snapdeal.service.impl.CartServiceImpl;
import com.snapdeal.service.impl.CustomerServiceImpl;
import com.snapdeal.service.impl.OrderServiceImpl;
import com.snapdeal.service.impl.ProductServiceImpl;
import com.snapdeal.util.AppScanner;

public class EcommerceApplication {

    private static final Scanner sc =
            AppScanner.getScanner();

    private static final CustomerService customerService =
            new CustomerServiceImpl();

    private static final ProductService productService =
            new ProductServiceImpl();

    private static final CartService cartService =
            new CartServiceImpl();

    private static final OrderService orderService =
            new OrderServiceImpl();

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println(" SNAPDEAL E-COMMERCE SYSTEM ");
        System.out.println("=================================");

        if (!login()) {

            System.out.println(
                    "Invalid Username or Password");

            return;
        }

        while (true) {

            System.out.println("\n========== MAIN MENU ==========");

            System.out.println("1. Customer Management");
            System.out.println("2. Product Management");
            System.out.println("3. Cart Management");
            System.out.println("4. Order Management");
            System.out.println("5. Reports");
            System.out.println("6. Exit");

            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    customerMenu();
                    break;

                case 2:
                    productMenu();
                    break;

                case 3:
                    cartMenu();
                    break;

                case 4:
                    orderMenu();
                    break;

                case 5:
                    reportMenu();
                    break;

                case 6:

                    System.out.println(
                            "Thank You Visit Again");

                    System.exit(0);

                default:

                    System.out.println(
                            "Invalid Choice");
            }
        }
    }

    private static boolean login() {

        sc.nextLine();

        System.out.println("\n===== LOGIN =====");

        System.out.print("Username : ");
        String username = sc.nextLine();

        System.out.print("Password : ");
        String password = sc.nextLine();

        return username.equals("admin")
                && password.equals("admin123");
    }

    private static void customerMenu() {

        System.out.println("\n----- CUSTOMER MENU -----");

        System.out.println("1. Register Customer");
        System.out.println("2. View Customer");
        System.out.println("3. Search Customer");
        System.out.println("4. Update Customer");
        System.out.println("5. Delete Customer");
        System.out.println("6. View All Customers");

        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                System.out.println(
                        "Register Customer");
                break;

            case 2:
                System.out.println(
                        "View Customer");
                break;

            case 3:
                System.out.println(
                        "Search Customer");
                break;

            case 4:
                System.out.println(
                        "Update Customer");
                break;

            case 5:
                System.out.println(
                        "Delete Customer");
                break;

            case 6:
                System.out.println(
                        "View All Customers");
                break;

            default:
                System.out.println(
                        "Invalid Choice");
        }
    }

    private static void productMenu() {

        System.out.println("\n----- PRODUCT MENU -----");

        System.out.println("1. Add Product");
        System.out.println("2. View All Products");
        System.out.println("3. Search Product By Id");
        System.out.println("4. Search Product By Name");
        System.out.println("5. Search Product By Category");
        System.out.println("6. Search Product By Brand");
        System.out.println("7. Update Product");
        System.out.println("8. Delete Product");
        System.out.println("9. Available Stock");

        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                System.out.println("Add Product");
                break;

            case 2:
                System.out.println("View Products");
                break;

            case 3:
                System.out.println("Search By Id");
                break;

            case 4:
                System.out.println("Search By Name");
                break;

            case 5:
                System.out.println("Search By Category");
                break;

            case 6:
                System.out.println("Search By Brand");
                break;

            case 7:
                System.out.println("Update Product");
                break;

            case 8:
                System.out.println("Delete Product");
                break;

            case 9:
                System.out.println("View Available Stock");
                break;

            default:
                System.out.println("Invalid Choice");
        }
    }

    private static void cartMenu() {

        System.out.println("\n----- CART MENU -----");

        System.out.println("1. Add Product To Cart");
        System.out.println("2. Remove Product From Cart");
        System.out.println("3. Increase Quantity");
        System.out.println("4. Decrease Quantity");
        System.out.println("5. View Cart");
        System.out.println("6. Calculate Cart Total");
        System.out.println("7. Clear Cart");

        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                System.out.println("Add To Cart");
                break;

            case 2:
                System.out.println("Remove From Cart");
                break;

            case 3:
                System.out.println("Increase Quantity");
                break;

            case 4:
                System.out.println("Decrease Quantity");
                break;

            case 5:
                System.out.println("View Cart");
                break;

            case 6:
                System.out.println("Calculate Total");
                break;

            case 7:
                System.out.println("Clear Cart");
                break;

            default:
                System.out.println("Invalid Choice");
        }
    }

    private static void orderMenu() {

        System.out.println("\n----- ORDER MENU -----");

        System.out.println("1. Place Order");
        System.out.println("2. View Order Details");
        System.out.println("3. View Customer Orders");
        System.out.println("4. Cancel Order");
        System.out.println("5. View All Orders");
        System.out.println("6. Order History");

        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                System.out.println("Place Order");
                break;

            case 2:
                System.out.println("View Order");
                break;

            case 3:
                System.out.println("Customer Orders");
                break;

            case 4:
                System.out.println("Cancel Order");
                break;

            case 5:
                System.out.println("All Orders");
                break;

            case 6:
                System.out.println("Order History");
                break;

            default:
                System.out.println("Invalid Choice");
        }
    }

    private static void reportMenu() {

        System.out.println("\n----- REPORT MENU -----");

        System.out.println("1. Total Orders");
        System.out.println("2. Total Revenue");
        System.out.println("3. Most Ordered Product");
        System.out.println("4. Low Stock Products");
        System.out.println("5. Customer Wise Orders");

        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                System.out.println("Total Orders");
                break;

            case 2:
                System.out.println("Total Revenue");
                break;

            case 3:
                System.out.println("Most Ordered Product");
                break;

            case 4:
                System.out.println("Low Stock Products");
                break;

            case 5:
                System.out.println("Customer Wise Orders");
                break;

            default:
                System.out.println("Invalid Choice");
        }
    }
}