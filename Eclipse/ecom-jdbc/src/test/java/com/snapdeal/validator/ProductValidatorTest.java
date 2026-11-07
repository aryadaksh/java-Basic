package com.snapdeal.validator;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class ProductValidatorTest {

    @Test
    void testValidProductName() {

        assertTrue(
                ProductValidator
                        .isValidProductName(
                                "Laptop"));
    }

    @Test
    void testInvalidProductName() {

        assertFalse(
                ProductValidator
                        .isValidProductName(
                                "L"));
    }

    @Test
    void testNullProductName() {

        assertFalse(
                ProductValidator
                        .isValidProductName(
                                null));
    }

    @Test
    void testValidCategory() {

        assertTrue(
                ProductValidator
                        .isValidCategory(
                                "Electronics"));
    }

    @Test
    void testInvalidCategory() {

        assertFalse(
                ProductValidator
                        .isValidCategory(
                                ""));
    }

    @Test
    void testNullCategory() {

        assertFalse(
                ProductValidator
                        .isValidCategory(
                                null));
    }

    @Test
    void testValidBrand() {

        assertTrue(
                ProductValidator
                        .isValidBrand(
                                "Dell"));
    }

    @Test
    void testInvalidBrand() {

        assertFalse(
                ProductValidator
                        .isValidBrand(
                                ""));
    }

    @Test
    void testNullBrand() {

        assertFalse(
                ProductValidator
                        .isValidBrand(
                                null));
    }

    @Test
    void testValidPrice() {

        assertTrue(
                ProductValidator
                        .isValidPrice(
                                new BigDecimal(
                                        "50000.00")));
    }

    @Test
    void testZeroPrice() {

        assertFalse(
                ProductValidator
                        .isValidPrice(
                                BigDecimal.ZERO));
    }

    @Test
    void testNegativePrice() {

        assertFalse(
                ProductValidator
                        .isValidPrice(
                                new BigDecimal(
                                        "-100")));
    }

    @Test
    void testNullPrice() {

        assertFalse(
                ProductValidator
                        .isValidPrice(
                                null));
    }

    @Test
    void testValidQuantity() {

        assertTrue(
                ProductValidator
                        .isValidQuantity(
                                10));
    }

    @Test
    void testZeroQuantity() {

        assertTrue(
                ProductValidator
                        .isValidQuantity(
                                0));
    }

    @Test
    void testNegativeQuantity() {

        assertFalse(
                ProductValidator
                        .isValidQuantity(
                                -1));
    }

    @Test
    void testNullQuantity() {

        assertFalse(
                ProductValidator
                        .isValidQuantity(
                                null));
    }

    @Test
    void testValidateProductSuccess() {

        assertTrue(
                ProductValidator
                        .validateProduct(
                                "Dell Laptop",
                                "Electronics",
                                "Dell",
                                new BigDecimal(
                                        "55000"),
                                10));
    }

    @Test
    void testValidateProductInvalidName() {

        assertFalse(
                ProductValidator
                        .validateProduct(
                                "L",
                                "Electronics",
                                "Dell",
                                new BigDecimal(
                                        "55000"),
                                10));
    }

    @Test
    void testValidateProductInvalidCategory() {

        assertFalse(
                ProductValidator
                        .validateProduct(
                                "Dell Laptop",
                                "",
                                "Dell",
                                new BigDecimal(
                                        "55000"),
                                10));
    }

    @Test
    void testValidateProductInvalidBrand() {

        assertFalse(
                ProductValidator
                        .validateProduct(
                                "Dell Laptop",
                                "Electronics",
                                "",
                                new BigDecimal(
                                        "55000"),
                                10));
    }

    @Test
    void testValidateProductInvalidPrice() {

        assertFalse(
                ProductValidator
                        .validateProduct(
                                "Dell Laptop",
                                "Electronics",
                                "Dell",
                                BigDecimal.ZERO,
                                10));
    }

    @Test
    void testValidateProductInvalidQuantity() {

        assertFalse(
                ProductValidator
                        .validateProduct(
                                "Dell Laptop",
                                "Electronics",
                                "Dell",
                                new BigDecimal(
                                        "55000"),
                                -5));
    }
}