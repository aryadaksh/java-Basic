package com.snapdeal.main;

import java.util.Scanner;

import com.snapdeal.service.CustomerService;
import com.snapdeal.service.OrderService;
import com.snapdeal.service.ProductService;
import com.snapdeal.service.impl.CustomerServiceImpl;
import com.snapdeal.service.impl.OrderServiceImpl;
import com.snapdeal.service.impl.ProductServiceImpl;
import com.snapdeal.util.AppScanner;
import com.snapdeal.util.ProductCSVImporter;

public class AdminMenu {

    private Scanner sc =
            AppScanner.getScanner();

    private CustomerService customerService =
            new CustomerServiceImpl();

    private ProductService productService =
            new ProductServiceImpl();

    private OrderService orderService =
            new OrderServiceImpl();

    public void showAdminMenu() {

        while (true) {

            System.out.println("\n================================");
            System.out.println("      ADMIN DASHBOARD");
            System.out.println("================================");

            System.out.println("1. Customer Management");
            System.out.println("2. Product Management");
            System.out.println("3. Order Management");
            System.out.println("4. Reports");
            System.out.println("5. Bulk Product Upload");
            System.out.println("6. Logout");

            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    customerManagement();
                    break;

                case 2:
                    productManagement();
                    break;

                case 3:
                    orderManagement();
                    break;

                case 4:
                    reportsMenu();
                    break;

                case 5:

                    sc.nextLine();

                    System.out.print(
                            "Enter CSV Path : ");

                    String path =
                            sc.nextLine();

                    ProductCSVImporter importer =
                            new ProductCSVImporter();

                    importer.importProducts(path);

                    break;

                case 6:
                	return;
                default:
                    System.out.println(
                            "Invalid Choice");
            }
        }
    }

    private void customerManagement() {

        System.out.println("\n===== CUSTOMERS =====");

        customerService.getAllCustomers()
                .forEach(System.out::println);
    }

    private void productManagement() {

        while (true) {

            System.out.println("\n===== PRODUCT MANAGEMENT =====");

            System.out.println("1. View Products");
            System.out.println("2. Available Stock");
            System.out.println("3. Back");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    productService.getAllProducts()
                            .forEach(System.out::println);

                    break;

                case 2:

                    productService.viewAvailableStock()
                            .forEach(System.out::println);

                    break;

                case 3:

                    return;
            }
        }
    }

    private void orderManagement() {

        System.out.println("\n===== ORDERS =====");

        orderService.getAllOrders()
                .forEach(System.out::println);
    }

    private void reportsMenu() {

        System.out.println("\n===== REPORTS =====");

        System.out.println("Total Customers : "
                + customerService.getAllCustomers().size());

        System.out.println("Total Products : "
                + productService.getAllProducts().size());

        System.out.println("Total Orders : "
                + orderService.getAllOrders().size());
    }
}