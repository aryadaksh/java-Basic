package com.snapdeal.validator;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class OrderValidatorTest {

    @Test
    void testValidCustomerId() {

        assertTrue(
                OrderValidator
                        .isValidCustomerId(1L));
    }

    @Test
    void testInvalidCustomerId() {

        assertFalse(
                OrderValidator
                        .isValidCustomerId(0L));
    }

    @Test
    void testNullCustomerId() {

        assertFalse(
                OrderValidator
                        .isValidCustomerId(null));
    }

    @Test
    void testValidProductId() {

        assertTrue(
                OrderValidator
                        .isValidProductId(1L));
    }

    @Test
    void testInvalidProductId() {

        assertFalse(
                OrderValidator
                        .isValidProductId(-1L));
    }

    @Test
    void testNullProductId() {

        assertFalse(
                OrderValidator
                        .isValidProductId(null));
    }

    @Test
    void testValidQuantity() {

        assertTrue(
                OrderValidator
                        .isValidQuantity(5));
    }

    @Test
    void testInvalidQuantity() {

        assertFalse(
                OrderValidator
                        .isValidQuantity(0));
    }

    @Test
    void testNullQuantity() {

        assertFalse(
                OrderValidator
                        .isValidQuantity(null));
    }

    @Test
    void testValidStock() {

        assertTrue(
                OrderValidator
                        .isValidStock(
                                10,
                                5));
    }

    @Test
    void testInvalidStock() {

        assertFalse(
                OrderValidator
                        .isValidStock(
                                5,
                                10));
    }

    @Test
    void testNullStock() {

        assertFalse(
                OrderValidator
                        .isValidStock(
                                null,
                                5));
    }

    @Test
    void testValidAmount() {

        assertTrue(
                OrderValidator
                        .isValidAmount(
                                new BigDecimal(
                                        "100.50")));
    }

    @Test
    void testInvalidAmount() {

        assertFalse(
                OrderValidator
                        .isValidAmount(
                                BigDecimal.ZERO));
    }

    @Test
    void testNegativeAmount() {

        assertFalse(
                OrderValidator
                        .isValidAmount(
                                new BigDecimal(
                                        "-50")));
    }

    @Test
    void testNullAmount() {

        assertFalse(
                OrderValidator
                        .isValidAmount(
                                null));
    }

    @Test
    void testValidateOrderSuccess() {

        assertTrue(
                OrderValidator
                        .validateOrder(
                                1L,
                                1L,
                                2,
                                10,
                                new BigDecimal(
                                        "500.00")));
    }

    @Test
    void testValidateOrderInvalidCustomer() {

        assertFalse(
                OrderValidator
                        .validateOrder(
                                0L,
                                1L,
                                2,
                                10,
                                new BigDecimal(
                                        "500.00")));
    }

    @Test
    void testValidateOrderInvalidProduct() {

        assertFalse(
                OrderValidator
                        .validateOrder(
                                1L,
                                0L,
                                2,
                                10,
                                new BigDecimal(
                                        "500.00")));
    }

    @Test
    void testValidateOrderInvalidQuantity() {

        assertFalse(
                OrderValidator
                        .validateOrder(
                                1L,
                                1L,
                                0,
                                10,
                                new BigDecimal(
                                        "500.00")));
    }

    @Test
    void testValidateOrderInsufficientStock() {

        assertFalse(
                OrderValidator
                        .validateOrder(
                                1L,
                                1L,
                                15,
                                10,
                                new BigDecimal(
                                        "500.00")));
    }

    @Test
    void testValidateOrderInvalidAmount() {

        assertFalse(
                OrderValidator
                        .validateOrder(
                                1L,
                                1L,
                                5,
                                10,
                                BigDecimal.ZERO));
    }
}