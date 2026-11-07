package com.snapdeal.validator;

import java.math.BigDecimal;

public class OrderValidator {

    private OrderValidator() {

    }

    public static boolean isValidCustomerId(
            Long customerId) {

        return customerId != null
                && customerId > 0;
    }

    public static boolean isValidProductId(
            Long productId) {

        return productId != null
                && productId > 0;
    }

    public static boolean isValidQuantity(
            Integer quantity) {

        return quantity != null
                && quantity > 0;
    }

    public static boolean isValidStock(
            Integer availableStock,
            Integer orderQuantity) {

        return availableStock != null
                && orderQuantity != null
                && availableStock >= orderQuantity;
    }

    public static boolean isValidAmount(
            BigDecimal amount) {

        return amount != null
                && amount.compareTo(
                        BigDecimal.ZERO) > 0;
    }

    public static boolean validateOrder(
            Long customerId,
            Long productId,
            Integer quantity,
            Integer availableStock,
            BigDecimal amount) {

        return isValidCustomerId(customerId)
                &&
                isValidProductId(productId)
                &&
                isValidQuantity(quantity)
                &&
                isValidStock(
                        availableStock,
                        quantity)
                &&
                isValidAmount(amount);
    }
}