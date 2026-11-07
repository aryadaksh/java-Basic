package com.snapdeal.validator;

import java.math.BigDecimal;

public class ProductValidator {

    private ProductValidator() {

    }

    public static boolean isValidProductName(
            String productName) {

        return productName != null
                && !productName.trim().isEmpty()
                && productName.length() >= 2;
    }

    public static boolean isValidCategory(
            String category) {

        return category != null
                && !category.trim().isEmpty();
    }

    public static boolean isValidBrand(
            String brand) {

        return brand != null
                && !brand.trim().isEmpty();
    }

    public static boolean isValidPrice(
            BigDecimal price) {

        return price != null
                && price.compareTo(
                        BigDecimal.ZERO) > 0;
    }

    public static boolean isValidQuantity(
            Integer quantity) {

        return quantity != null
                && quantity >= 0;
    }

    public static boolean validateProduct(
            String productName,
            String category,
            String brand,
            BigDecimal price,
            Integer quantity) {

        return isValidProductName(productName)
                &&
                isValidCategory(category)
                &&
                isValidBrand(brand)
                &&
                isValidPrice(price)
                &&
                isValidQuantity(quantity);
    }
}
