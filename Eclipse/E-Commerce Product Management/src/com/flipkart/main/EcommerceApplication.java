package com.flipkart.main;

import java.util.Scanner;

import com.flipkart.repository.CustomerRepository;
import com.flipkart.repository.OrderRepository;
import com.flipkart.repository.ProductRepository;
import com.flipkart.service.CartService;
import com.flipkart.service.CustomerService;
import com.flipkart.service.OrderService;
import com.flipkart.service.ProductService;

public class EcommerceApplication {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ProductRepository productRepo = new ProductRepository();
		CustomerRepository customerRepo = new CustomerRepository();
		OrderRepository orderRepo = new OrderRepository();

		ProductService productService = new ProductService(productRepo);
		CustomerService customerService = new CustomerService(customerRepo);
		CartService cartService = new CartService();
		OrderService orderService = new OrderService(orderRepo, productRepo, cartService);

		int customerId = 101; // demo customer

		while (true) {
			System.out.println("\n===== E-Commerce System =====");
			System.out.println("1. Admin Menu");
			System.out.println("2. Customer Menu");
			System.out.println("3. Exit");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				adminMenu(sc, productService, customerService, orderService);
				break;
			case 2:
				customerMenu(sc, productService, customerService, cartService, orderService, customerId);
				break;
			case 3:
				System.exit(0);
			default:
				System.out.println("Invalid choice!");
			}
		}
	}

	private static void adminMenu(Scanner sc, ProductService productService, CustomerService customerService,
			OrderService orderService) {
		System.out.println("\n=== Admin Menu ===");
		System.out.println("1. Add Product");
		System.out.println("2. View Products");
		System.out.println("3. Search Product by ID");
		System.out.println("4. Update Product Price");
		System.out.println("5. Update Product Quantity");
		System.out.println("6. Delete Product");
		System.out.println("7. View Customers");
		System.out.println("8. View All Orders");
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			System.out.print("Enter product name: ");
			String name = sc.nextLine();  // allows spaces

			System.out.print("Enter category: ");
			String category = sc.nextLine();

			System.out.print("Enter price: ");
			double price = sc.nextDouble();

			System.out.print("Enter quantity: ");
			int qty = sc.nextInt();
			sc.nextLine(); // consume leftover newline

			System.out.print("Enter brand: ");
			String brand = sc.nextLine();
			productService.addProduct(new Product(name, category, price, qty, brand));
			break;
		case 2:
			productService.viewAllProducts().forEach(System.out::println);
			break;
		case 3:
			System.out.print("ID: ");
			int id = sc.nextInt();
			System.out.println(productService.searchById(id));
			break;
		case 4:
			System.out.print("ID: ");
			int idp = sc.nextInt();
			System.out.print("New Price: ");
			double np = sc.nextDouble();
			productService.updatePrice(idp, np);
			break;
		case 5:
			System.out.print("ID: ");
			int idq = sc.nextInt();
			System.out.print("New Qty: ");
			int nq = sc.nextInt();
			productService.updateQuantity(idq, nq);
			break;
		case 6:
			System.out.print("ID: ");
			int del = sc.nextInt();
			productService.deleteProduct(del);
			break;
		case 7:
			customerService.viewAllCustomers().forEach(System.out::println);
			break;
		case 8:
			orderService.viewAllOrders().forEach(System.out::println);
			break;
		default:
			System.out.println("Invalid choice!");
		}
	}

	private static void customerMenu(Scanner sc, ProductService productService, CustomerService customerService,
			CartService cartService, OrderService orderService, int customerId) {
		System.out.println("\n=== Customer Menu ===");
		System.out.println("1. Register");
		System.out.println("2. View Products");
		System.out.println("3. Search Product");
		System.out.println("4. Add Product to Cart");
		System.out.println("5. View Cart");
		System.out.println("6. Remove Product from Cart");
		System.out.println("7. Place Order");
		System.out.println("8. View My Orders");
		System.out.println("9. Cancel Order");
		System.out.println("10. Logout");
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			System.out.print("Enter ID: ");
			int id = sc.nextInt();
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Email: ");
			String email = sc.next();
			System.out.print("Mobile: ");
			String mobile = sc.next();
			System.out.print("Address: ");
			String addr = sc.next();
			customerService.registerCustomer(new Customer(id, name, email, mobile, addr));
			System.out.println("Customer registered!");
			break;

		case 2:
			productService.viewAllProducts().forEach(System.out::println);
			break;

		case 3:
			System.out.println("Search by: 1.ID 2.Name 3.Category 4.Brand 5.PriceRange");
			int s = sc.nextInt();
			switch (s) {
			case 1:
				System.out.print("ID: ");
				int sid = sc.nextInt();
				System.out.println(productService.searchById(sid));
				break;
			case 2:
				System.out.print("Name: ");
				String sn = sc.next();
				productService.searchByName(sn).forEach(System.out::println);
				break;
			case 3:
				System.out.print("Category: ");
				String sca = sc.next();
				productService.searchByCategory(sca).forEach(System.out::println);
				break;
			case 4:
				System.out.print("Brand: ");
				String sb = sc.next();
				productService.searchByBrand(sb).forEach(System.out::println);
				break;
			case 5:
				System.out.print("Min: ");
				double min = sc.nextDouble();
				System.out.print("Max: ");
				double max = sc.nextDouble();
				productService.searchByPriceRange(min, max).forEach(System.out::println);
				break;
			}
			break;

		case 4:
			System.out.print("Product ID: ");
			int pid = sc.nextInt();
			System.out.print("Quantity: ");
			int qty = sc.nextInt();
			Product prod = productService.searchById(pid);
			if (prod != null) {
				cartService.addToCart(customerId, prod, qty);
				System.out.println("Added to cart!");
			} else {
				System.out.println("Product not found!");
			}
			break;

		case 5:
			cartService.viewCart(customerId).forEach(System.out::println);
			System.out.println("Cart Total: Rs." + cartService.calculateTotal(customerId));
			break;

		case 6:
			System.out.print("Product ID to remove: ");
			int rid = sc.nextInt();
			cartService.removeFromCart(customerId, rid);
			System.out.println("Removed from cart!");
			break;

		case 7:
			try {
				Order order = orderService.placeOrder(customerId);
				System.out.println("Order placed: " + order);
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
			break;

		case 8:
			orderService.viewOrdersByCustomer(customerId).forEach(System.out::println);
			break;

		case 9:
			System.out.print("Order ID to cancel: ");
			int oid = sc.nextInt();
			orderService.cancelOrder(oid);
			System.out.println("Order cancelled if found.");
			break;

		case 10:
			System.out.println("Logged out.");
			return;

		default:
			System.out.println("Invalid choice!");
		}
	}
}
