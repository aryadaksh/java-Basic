package com.snapdeal.validator;

import java.util.regex.Pattern;

public class CustomerValidator {

    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    private static final String MOBILE_REGEX =
            "^[6-9][0-9]{9}$";

    private CustomerValidator() {

    }

    public static boolean isValidCustomerName(
            String customerName) {

        return customerName != null
                && !customerName.trim().isEmpty()
                && customerName.length() >= 3;
    }

    public static boolean isValidEmail(
            String email) {

        return email != null
                && Pattern.matches(
                        EMAIL_REGEX,
                        email);
    }

    public static boolean isValidMobile(
            String mobile) {

        return mobile != null
                && Pattern.matches(
                        MOBILE_REGEX,
                        mobile);
    }

    public static boolean isValidAddress(
            String address) {

        return address != null
                && !address.trim().isEmpty();
    }

    public static boolean validateCustomer(
            String customerName,
            String email,
            String mobile,
            String address) {

        return isValidCustomerName(
                    customerName)
                &&
                isValidEmail(email)
                &&
                isValidMobile(mobile)
                &&
                isValidAddress(address);
    }
}