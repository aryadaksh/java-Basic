package com.snapdeal.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CustomerValidatorTest {

    @Test
    void testValidCustomerName() {

        assertTrue(
                CustomerValidator
                        .isValidCustomerName(
                                "Daksh"));
    }

    @Test
    void testInvalidCustomerName() {

        assertFalse(
                CustomerValidator
                        .isValidCustomerName(
                                "Da"));
    }

    @Test
    void testNullCustomerName() {

        assertFalse(
                CustomerValidator
                        .isValidCustomerName(
                                null));
    }

    @Test
    void testValidEmail() {

        assertTrue(
                CustomerValidator
                        .isValidEmail(
                                "daksh@gmail.com"));
    }

    @Test
    void testInvalidEmail() {

        assertFalse(
                CustomerValidator
                        .isValidEmail(
                                "dakshgmail.com"));
    }

    @Test
    void testNullEmail() {

        assertFalse(
                CustomerValidator
                        .isValidEmail(
                                null));
    }

    @Test
    void testValidMobile() {

        assertTrue(
                CustomerValidator
                        .isValidMobile(
                                "9876543210"));
    }

    @Test
    void testInvalidMobile_Length() {

        assertFalse(
                CustomerValidator
                        .isValidMobile(
                                "987654321"));
    }

    @Test
    void testInvalidMobile_StartsWithFive() {

        assertFalse(
                CustomerValidator
                        .isValidMobile(
                                "5876543210"));
    }

    @Test
    void testNullMobile() {

        assertFalse(
                CustomerValidator
                        .isValidMobile(
                                null));
    }

    @Test
    void testValidAddress() {

        assertTrue(
                CustomerValidator
                        .isValidAddress(
                                "Bangalore"));
    }

    @Test
    void testInvalidAddress() {

        assertFalse(
                CustomerValidator
                        .isValidAddress(
                                ""));
    }

    @Test
    void testNullAddress() {

        assertFalse(
                CustomerValidator
                        .isValidAddress(
                                null));
    }

    @Test
    void testValidateCustomer_Valid() {

        assertTrue(
                CustomerValidator
                        .validateCustomer(
                                "Daksh",
                                "daksh@gmail.com",
                                "9876543210",
                                "Bangalore"));
    }

    @Test
    void testValidateCustomer_InvalidEmail() {

        assertFalse(
                CustomerValidator
                        .validateCustomer(
                                "Daksh",
                                "dakshgmail.com",
                                "9876543210",
                                "Bangalore"));
    }

    @Test
    void testValidateCustomer_InvalidMobile() {

        assertFalse(
                CustomerValidator
                        .validateCustomer(
                                "Daksh",
                                "daksh@gmail.com",
                                "1234567890",
                                "Bangalore"));
    }

    @Test
    void testValidateCustomer_InvalidAddress() {

        assertFalse(
                CustomerValidator
                        .validateCustomer(
                                "Daksh",
                                "daksh@gmail.com",
                                "9876543210",
                                ""));
    }
}