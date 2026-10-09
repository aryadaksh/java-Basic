package com.main;

import java.util.Scanner;

import com.service.CartService;
import com.service.CustomerService;
import com.service.OrderService;
import com.service.ProductService;

public class EcommerceApplication {
	
	static {
		System.out.println("=============================================================");
		System.out.println(" ========E-Commerce Product & Order Management System=======");
		System.out.println("=============================================================");
	}
	
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Scanner sc = new Scanner(System.in);
        ProductService productService = new ProductService();
        CustomerService customerService = new CustomerService();
        CartService cartService = new CartService();
        OrderService orderService = new OrderService();
        while(true) {
            System.out.println("1. Admin\n2. Customer\n3. Exit");
            int choice = sc.nextInt();
            switch(choice) {
                case 1: // Admin menu
                    // call productService methods
                    break;
                case 2: // Customer menu
                    // call customerService/cartService/orderService
                    break;
                case 3:
                    System.exit(0);
            }
        }
		
		
	
		
		
	}

}
