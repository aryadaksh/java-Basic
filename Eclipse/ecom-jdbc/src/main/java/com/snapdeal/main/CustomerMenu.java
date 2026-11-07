package com.snapdeal.main;

import java.util.Scanner;

import com.snapdeal.model.Cart;
import com.snapdeal.model.Customer;
import com.snapdeal.service.CartService;
import com.snapdeal.service.CustomerService;
import com.snapdeal.service.OrderService;
import com.snapdeal.service.ProductService;
import com.snapdeal.service.impl.CartServiceImpl;
import com.snapdeal.service.impl.CustomerServiceImpl;
import com.snapdeal.service.impl.OrderServiceImpl;
import com.snapdeal.service.impl.ProductServiceImpl;
import com.snapdeal.util.AppScanner;

public class CustomerMenu {
	
	private static final Long GUEST_CUSTOMER_ID = 999L;
	
	private boolean guestUser;

	private Long customerId;
	
	

	public CustomerMenu() {

	    this(false, null);
	}

	public CustomerMenu(
	        boolean guestUser) {

	    this(guestUser, null);
	}

	public CustomerMenu(
	        boolean guestUser,
	        Long customerId) {

	    this.guestUser = guestUser;
	    this.customerId = customerId;
	}

    private Scanner sc = AppScanner.getScanner();

    private ProductService productService =
            new ProductServiceImpl();

    
    private OrderService orderService =
            new OrderServiceImpl();

    private CustomerService customerService =
            new CustomerServiceImpl();
    
    private CartService cartService =
            new CartServiceImpl();
    
    public void showCustomerMenu() {

        while (true) {

            System.out.println(
                    "\n================================");

            System.out.println(
                    guestUser
                            ? "      GUEST DASHBOARD"
                            : "      CUSTOMER DASHBOARD");

            System.out.println(
                    "================================");

            System.out.println(
                    "1. Product Catalog");

            System.out.println(
                    "2. Cart Management");

            if (!guestUser) {

                System.out.println(
                        "3. My Orders");

                System.out.println(
                        "4. My Profile");
            }

            System.out.println(
                    "5. Logout");

            System.out.print(
                    "Enter Choice : ");

            int choice =
                    sc.nextInt();

            if (guestUser) {

                switch (choice) {

                    case 1:
                        productCatalog();
                        break;

                    case 2:
                        cartMenu();
                        break;

                    case 5:
                        return;

                    default:
                        System.out.println(
                                "Invalid Choice");
                }

            } else {

                switch (choice) {

                    case 1:
                        productCatalog();
                        break;

                    case 2:
                        cartMenu();
                        break;

                    case 3:
                        orderMenu();
                        break;

                    case 4:
                        profileMenu();
                        break;

                    case 5:
                        return;

                    default:
                        System.out.println(
                                "Invalid Choice");
                }
            }
        }
    }

    private void productCatalog() {

        while (true) {

            System.out.println("\n===== PRODUCT CATALOG =====");

            System.out.println("1. View All Products");
            System.out.println("2. Search Product By Id");
            System.out.println("3. Search Product By Name");
            System.out.println("4. Search Product By Category");
            System.out.println("5. Search Product By Brand");
            System.out.println("6. Back");

            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    productService.getAllProducts()
                            .forEach(System.out::println);

                    break;

                case 2:

                    System.out.print(
                            "Enter Product Id : ");

                    Long id = sc.nextLong();

                    System.out.println(
                            productService.getProductById(id));

                    break;

                case 3:

                    sc.nextLine();

                    System.out.print(
                            "Enter Product Name : ");

                    String name = sc.nextLine();

                    System.out.println(
                            productService.getProductByName(
                                    name));

                    break;

                case 4:

                    sc.nextLine();

                    System.out.print(
                            "Enter Category : ");

                    String category =
                            sc.nextLine();

                    productService
                            .getProductsByCategory(category)
                            .forEach(System.out::println);

                    break;

                case 5:

                    sc.nextLine();

                    System.out.print(
                            "Enter Brand : ");

                    String brand =
                            sc.nextLine();

                    productService
                            .getProductsByBrand(brand)
                            .forEach(System.out::println);

                    break;

                case 6:
                    return;

                default:
                    System.out.println(
                            "Invalid Choice");
            }
        }
    }

    private void cartMenu() {

        while (true) {

            System.out.println("\n===== CART MENU =====");

            System.out.println("1. Add To Cart");
            System.out.println("2. Remove From Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Calculate Cart Total");
            System.out.println("5. Clear Cart");
            System.out.println("6. Back");

            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                	Long customerId;

                	if(guestUser) {

                	    customerId =
                	            GUEST_CUSTOMER_ID;

                	} else {

                	    System.out.print(
                	            "Enter Customer Id : ");

                	    customerId =
                	            sc.nextLong();
                	}

                    System.out.print(
                            "Enter Product Id : ");

                    Long productId =
                            sc.nextLong();

                    System.out.print(
                            "Enter Quantity : ");

                    int quantity =
                            sc.nextInt();

                    Cart cart =
                            new Cart();

                    cart.setCustomerId(
                            customerId);

                    cart.setProductId(
                            productId);

                    cart.setQuantity(
                            quantity);

                    boolean added =
                            cartService.addToCart(
                                    cart);

                    if (added) {

                        System.out.println(
                            "Product Added To Cart Successfully");
                    } else {

                        System.out.println(
                            "Unable To Add Product");
                    }

                    break;

                case 2:

                    System.out.print(
                            "Enter Cart Id : ");

                    Long cartId =
                            sc.nextLong();

                    boolean removed =
                            cartService.removeFromCart(
                                    cartId);

                    if (removed) {

                        System.out.println(
                                "Product Removed Successfully");
                    }

                    break;

                case 3:

                    System.out.print(
                            "Enter Customer Id : ");

                    Long viewCustomerId =
                            sc.nextLong();

                    cartService.viewCart(
                            viewCustomerId)
                            .forEach(
                                    System.out::println);

                    break;

                case 4:

                    System.out.print(
                            "Enter Customer Id : ");

                    Long totalCustomerId =
                            sc.nextLong();

                    double total =
                            cartService.calculateCartTotal(
                                    totalCustomerId);

                    System.out.println(
                            "Cart Total : ₹" + total);

                    break;

                case 5:

                    System.out.print(
                            "Enter Customer Id : ");

                    Long clearCustomerId =
                            sc.nextLong();

                    boolean cleared =
                            cartService.clearCart(
                                    clearCustomerId);

                    if (cleared) {

                        System.out.println(
                                "Cart Cleared Successfully");
                    }

                    break;

                case 6:

                    return;

                default:

                    System.out.println(
                            "Invalid Choice");
            }
        }
    }

    private void orderMenu() {
    	
    	 if (guestUser) {

    	        System.out.println(
    	                "\n================================");

    	        System.out.println(
    	                "LOGIN REQUIRED");

    	        System.out.println(
    	                "================================");

    	        System.out.println(
    	                "Guest users cannot place orders.");

    	        System.out.println(
    	                "Please login first.");

    	        return;
    	    }

        while (true) {

            System.out.println("\n===== ORDER MENU =====");

            System.out.println("1. Place Order");
            System.out.println("2. View Orders");
            System.out.println("3. Cancel Order");
            System.out.println("4. Back");

            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print(
                            "Enter Customer Id : ");

                    Long customerId =
                            sc.nextLong();

                    boolean orderPlaced =
                            orderService.placeOrder(
                                    customerId);

                    if (orderPlaced) {

                        System.out.println(
                                "Order Placed Successfully");
                    } else {

                        System.out.println(
                                "Order Placement Failed");
                    }

                    break;

                case 2:

                    System.out.print(
                            "Enter Customer Id : ");

                    Long viewCustomerId =
                            sc.nextLong();

                    orderService
                            .getCustomerOrders(
                                    viewCustomerId)
                            .forEach(
                                    System.out::println);

                    break;

                case 3:

                    System.out.print(
                            "Enter Order Id : ");

                    Long orderId =
                            sc.nextLong();

                    boolean cancelled =
                            orderService.cancelOrder(
                                    orderId);

                    if (cancelled) {

                        System.out.println(
                                "Order Cancelled Successfully");
                    } else {

                        System.out.println(
                                "Unable To Cancel Order");
                    }

                    break;

                case 4:

                    return;

                default:

                    System.out.println(
                            "Invalid Choice");
            }
        }
    }

    private void profileMenu() {
    	
        if (guestUser) {

            System.out.println(
                    "\nPlease login to access profile.");

            return;
        }


        while (true) {

            System.out.println("\n===== PROFILE MENU =====");

            System.out.println("1. View Profile");
            System.out.println("2. Update Profile");
            System.out.println("3. Back");

            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print(
                            "Enter Customer Id : ");

                    Long customerId =
                            sc.nextLong();

                    Customer customer =
                            customerService
                                    .getCustomerById(
                                            customerId);

                    if (customer != null) {

                        System.out.println(
                                customer);

                    } else {

                        System.out.println(
                                "Customer Not Found");
                    }

                    break;

                case 2:

                    System.out.print(
                            "Enter Customer Id : ");

                    Long id =
                            sc.nextLong();

                    sc.nextLine();

                    Customer updateCustomer =
                            customerService
                                    .getCustomerById(id);

                    if (updateCustomer == null) {

                        System.out.println(
                                "Customer Not Found");

                        break;
                    }

                    System.out.print(
                            "Enter New Name : ");

                    updateCustomer.setCustomerName(
                            sc.nextLine());

                    System.out.print(
                            "Enter New Email : ");

                    updateCustomer.setEmail(
                            sc.nextLine());

                    System.out.print(
                            "Enter New Mobile : ");

                    updateCustomer.setMobile(
                            sc.nextLine());

                    System.out.print(
                            "Enter New Address : ");

                    updateCustomer.setAddress(
                            sc.nextLine());

                    boolean updated =
                            customerService
                                    .updateCustomer(
                                            updateCustomer);

                    if (updated) {

                        System.out.println(
                                "Profile Updated Successfully");

                    } else {

                        System.out.println(
                                "Profile Update Failed");
                    }

                    break;

                case 3:

                    return;

                default:

                    System.out.println(
                            "Invalid Choice");
            }
        }
    }
}