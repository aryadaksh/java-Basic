package com.snapdeal.dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.snapdeal.model.Product;
import com.snapdeal.util.DBConnection;

public class ProductDAOImplTest {

    private final ProductDAOImpl productDAO =
            new ProductDAOImpl();

    @Test
    void testSaveProduct() {

        Product product =
                new Product();

        long unique =
                System.currentTimeMillis();

        product.setProductName(
                "Test Product " + unique);

        product.setCategory(
                "Electronics");

        product.setPrice(
                new BigDecimal("999.99"));

        product.setQuantity(
                10);

        product.setBrand(
                "TestBrand");

        boolean result =
                productDAO.save(product);

        assertTrue(result);
    }

    @Test
    void testFindById() {

        Optional<Product> product =
                productDAO.findById(1L);

        assertTrue(
                product.isPresent());
    }

    @Test
    void testFindByIdNotFound() {

        Optional<Product> product =
                productDAO.findById(
                        999999L);

        assertFalse(
                product.isPresent());
    }

    @Test
    void testFindByName() {

        Optional<Product> product =
                productDAO.findByName(
                        "Mouse");

        assertNotNull(product);
    }

    @Test
    void testFindByCategory() {

        List<Product> products =
                productDAO.findByCategory(
                        "Electronics");

        assertNotNull(products);
    }

    @Test
    void testFindByBrand() {

        List<Product> products =
                productDAO.findByBrand(
                        "VoltEdge");

        assertNotNull(products);
    }

    @Test
    void testFindAll() {

        List<Product> products =
                productDAO.findAll();

        assertNotNull(products);

        assertFalse(
                products.isEmpty());
    }

    @Test
    void testViewAvailableStock() {

        List<Product> products =
                productDAO.viewAvailableStock();

        assertNotNull(products);
    }

    @Test
    void testUpdateProduct() {

        Optional<Product> productOpt =
                productDAO.findById(1L);

        assertTrue(
                productOpt.isPresent());

        Product product =
                productOpt.get();

        product.setQuantity(
                product.getQuantity() + 1);

        boolean result =
                productDAO.update(
                        product);

        assertTrue(result);
    }

    @Test
    void testUpdateStock() {

        boolean result =
                productDAO.updateStock(
                        1L,
                        20);

        assertTrue(result);
    }

    @Test
    void testReduceStock() {

        try(Connection con =
                    DBConnection.getConnection()) {

            boolean result =
                    productDAO.reduceStock(
                            1L,
                            1,
                            con);

            assertTrue(result);

        } catch(Exception e) {

            fail(e.getMessage());
        }
    }

    @Test
    void testIncreaseStock() {

        try(Connection con =
                    DBConnection.getConnection()) {

            boolean result =
                    productDAO.increaseStock(
                            1L,
                            1,
                            con);

            assertTrue(result);

        } catch(Exception e) {

            fail(e.getMessage());
        }
    }

    @Test
    void testAddProductsBatch() {

        List<Product> products =
                new ArrayList<>();

        Product product1 =
                new Product();

        product1.setProductName(
                "Batch Product 1");

        product1.setCategory(
                "Electronics");

        product1.setPrice(
                new BigDecimal("100"));

        product1.setQuantity(
                5);

        product1.setBrand(
                "Brand1");

        Product product2 =
                new Product();

        product2.setProductName(
                "Batch Product 2");

        product2.setCategory(
                "Electronics");

        product2.setPrice(
                new BigDecimal("200"));

        product2.setQuantity(
                10);

        product2.setBrand(
                "Brand2");

        products.add(product1);
        products.add(product2);

        assertDoesNotThrow(
                () -> productDAO.addProductsBatch(
                        products));
    }

    @Test
    void testDeleteProduct() {

        Product product =
                new Product();

        long unique =
                System.currentTimeMillis();

        product.setProductName(
                "Delete Product " + unique);

        product.setCategory(
                "Test");

        product.setPrice(
                new BigDecimal("500"));

        product.setQuantity(
                5);

        product.setBrand(
                "DeleteBrand");

        productDAO.save(product);

        Optional<Product> saved =
                productDAO.findByName(
                        "Delete Product");

        if(saved.isPresent()) {

            boolean deleted =
                    productDAO.delete(
                            saved.get()
                                 .getProductId());

            assertTrue(deleted);
        }
    }
}