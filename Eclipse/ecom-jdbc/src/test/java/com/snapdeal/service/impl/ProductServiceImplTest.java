package com.snapdeal.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.snapdeal.model.Product;

public class ProductServiceImplTest {

    private final ProductServiceImpl productService =
            new ProductServiceImpl();

    @Test
    public void testAddProduct() {

        Product product = new Product();

        product.setProductName("HP Laptop");
        product.setCategory("Electronics");
        product.setPrice(new BigDecimal("55000"));
        product.setQuantity(10);
        product.setBrand("HP");

        boolean result =
                productService.addProduct(product);

        assertTrue(result);
    }

    @Test
    public void testGetProductById() {

        Product product =
                productService.getProductById(1L);

        assertNotNull(product);
    }

    @Test
    public void testGetProductByName() {

        Product product =
                productService.getProductByName(
                        "HP Laptop");

        assertNotNull(product);
    }

    @Test
    public void testGetProductsByCategory() {

        List<Product> products =
                productService.getProductsByCategory(
                        "Electronics");

        assertNotNull(products);
    }

    @Test
    public void testGetProductsByBrand() {

        List<Product> products =
                productService.getProductsByBrand(
                        "HP");

        assertNotNull(products);
    }

    @Test
    public void testGetAllProducts() {

        List<Product> products =
                productService.getAllProducts();

        assertNotNull(products);
    }

    @Test
    public void testViewAvailableStock() {

        List<Product> products =
                productService.viewAvailableStock();

        assertNotNull(products);
    }

    @Test
    public void testUpdateStock() {

        boolean result =
                productService.updateStock(
                        1L,
                        20);

        assertTrue(result);
    }

    @Test
    public void testUpdateProduct() {

        Product product =
                productService.getProductById(
                        1L);

        if (product != null) {

            product.setPrice(
                    new BigDecimal("60000"));

            boolean result =
                    productService.updateProduct(
                            product);

            assertTrue(result);
        }
    }

    @Test
    public void testDeleteProduct() {

        Product product =
                new Product();

        product.setProductName(
                "Delete Product");

        product.setCategory(
                "Test");

        product.setPrice(
                new BigDecimal("100"));

        product.setQuantity(2);

        product.setBrand(
                "Test");

        productService.addProduct(product);

        Product savedProduct =
                productService.getProductByName(
                        "Delete Product");

        assertNotNull(savedProduct);

        boolean result =
                productService.deleteProduct(
                        savedProduct.getProductId());

        assertTrue(result);
    }
}