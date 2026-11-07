package com.snapdeal.ecom_jdbc;



import java.util.Scanner;

import com.snapdeal.dao.CredentialDAO;
import com.snapdeal.dao.CustomerDAO;
import com.snapdeal.dao.impl.CredentialDAOImpl;
import com.snapdeal.dao.impl.CustomerDAOImpl;
import com.snapdeal.main.AdminMenu;
import com.snapdeal.main.CustomerMenu;
import com.snapdeal.model.Customer;
import com.snapdeal.util.AppScanner;

public class App {

    private static final Scanner sc =
            AppScanner.getScanner();
    
    
    private static boolean customerLogin() {

        sc.nextLine();

        System.out.println(
                "\n===== CUSTOMER LOGIN =====");

        System.out.print(
                "Username : ");

        String username =
                sc.nextLine();

        System.out.print(
                "Password : ");

        String password =
                sc.nextLine();

        CredentialDAO credentialDAO =
                new CredentialDAOImpl();

        return credentialDAO
                .validateLogin(
                        username,
                        password);
    }
    
	/*
	 * private static String generatePassword( String name, String mobile) {
	 * 
	 * String firstName = name.split(" ")[0];
	 * 
	 * String lastThreeDigits = mobile.substring( mobile.length() - 3);
	 * 
	 * return firstName + "@" + lastThreeDigits; }
	 */
    
    private static boolean adminLogin() {

        sc.nextLine();

        System.out.println(
                "\n===== ADMIN LOGIN =====");

        System.out.print(
                "Username : ");

        String username =
                sc.nextLine();

        System.out.print(
                "Password : ");

        String password =
                sc.nextLine();

        CredentialDAO credentialDAO =
                new CredentialDAOImpl();

        return credentialDAO
                .validateAdminLogin(
                        username,
                        password);
    }
    
    private static String generateUsername(
            String name,
            String mobile) {

        String firstName =
                name.split(" ")[0]
                        .toLowerCase();

        String lastTwoDigits =
                mobile.substring(
                        mobile.length() - 2);

        return firstName +
                lastTwoDigits;
    }
    
    private static void registerCustomer() {

        sc.nextLine();

        System.out.print("Enter Customer Name : ");
        String name = sc.nextLine();

        System.out.print("Enter Email : ");
        String email = sc.nextLine();

        System.out.print("Enter Mobile : ");
        String mobile = sc.nextLine();

        System.out.print("Enter Address : ");
        String address = sc.nextLine();

        String username =
                generateUsername(
                        name,
                        mobile);

        System.out.print("Create Password : ");
        String password = sc.nextLine();

        System.out.print("Confirm Password : ");
        String confirmPassword = sc.nextLine();

        if (!password.equals(confirmPassword)) {

            System.out.println(
                    "Passwords do not match");

            return;
        }

        Customer customer =
                new Customer();

        customer.setCustomerName(name);
        customer.setEmail(email);
        customer.setMobile(mobile);
        customer.setAddress(address);

        CustomerDAO customerDAO =
                new CustomerDAOImpl();

        boolean customerSaved =
                customerDAO.save(customer);

        if (!customerSaved) {

            System.out.println(
                    "Customer Registration Failed");

            return;
        }

        Customer savedCustomer =
                customerDAO
                .findByEmail(email)
                .orElse(null);

        if (savedCustomer == null) {

            System.out.println(
                    "Unable to fetch Customer Details");

            return;
        }

        Long customerId =
                savedCustomer.getCustomerId();

        CredentialDAO credentialDAO =
                new CredentialDAOImpl();

        boolean credentialSaved =
                credentialDAO.saveCredentials(
                        customerId,
                        username,
                        password);

        if (credentialSaved) {

            System.out.println(
                    "\nCustomer Registered Successfully");

            System.out.println(
                    "Username : " + username);

            System.out.println(
                    "Please Login Using Your Credentials");

        } else {

            System.out.println(
                    "Failed To Save Login Credentials");
        }
    }
    public static void main(String[] args) {

        while (true) {

            System.out.println(
                    "\n================================");

            System.out.println(
                    "SNAPDEAL E-COMMERCE SYSTEM");

            System.out.println(
                    "================================");

            System.out.println(
                    "1. Admin Login");

            System.out.println(
                    "2. Customer Registration");

            System.out.println(
                    "3. Customer Login");

            System.out.println(
                    "4. Continue As Guest");

            System.out.println(
                    "5. Exit");

            System.out.print(
                    "Enter Choice : ");

            int choice = sc.nextInt();

            switch (choice) {

            case 1:

                if(adminLogin()) {

                    AdminMenu adminMenu =
                            new AdminMenu();

                    adminMenu.showAdminMenu();

                } else {

                    System.out.println(
                            "Invalid Admin Username or Password");
                }

                break;

                case 2:

                	registerCustomer();

                    break;

                case 3:

                    if(customerLogin()) {

                        CustomerMenu customerMenu =
                                new CustomerMenu();

                        customerMenu.showCustomerMenu();

                    } else {

                        System.out.println(
                                "Invalid Username or Password");
                    }

                    break;
                case 4:

                    System.exit(0);

                default:

                    System.out.println(
                            "Invalid Choice");
            }
        }
    }
}