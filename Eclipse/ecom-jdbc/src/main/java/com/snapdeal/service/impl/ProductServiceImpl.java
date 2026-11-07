package com.snapdeal.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.snapdeal.dao.ProductDAO;
import com.snapdeal.dao.impl.ProductDAOImpl;
import com.snapdeal.exception.DatabaseOperationException;
import com.snapdeal.exception.DuplicateProductException;
import com.snapdeal.exception.InvalidPriceException;
import com.snapdeal.exception.InvalidQuantityException;
import com.snapdeal.exception.ProductNotFoundException;
import com.snapdeal.exception.ProductOutOfStockException;
import com.snapdeal.model.Product;
import com.snapdeal.service.ProductService;

public class ProductServiceImpl
        implements ProductService {

    private ProductDAO productDAO =
            new ProductDAOImpl();

    @Override
    public boolean addProduct(
            Product product) {

        if (product == null) {

            throw new ProductNotFoundException(
                    "Product data is null");
        }

        if (product.getPrice().doubleValue() <= 0) {

            throw new InvalidPriceException(
                    "Price must be greater than zero");
        }

        if (product.getQuantity() <= 0) {

            throw new InvalidQuantityException(
                    "Quantity must be greater than zero");
        }

        Product existingProduct =
                productDAO.findByName(
                        product.getProductName())
                        .orElse(null);

        if (existingProduct != null) {

            throw new DuplicateProductException(
                    "Product already exists");
        }

        return productDAO.save(product);
    }

    @Override
    public boolean updateProduct(
            Product product) {

        productDAO.findById(
                product.getProductId())
                .orElseThrow(() ->
                        new ProductNotFoundException(
                                "Product not found"));

        if (product.getPrice().doubleValue() <= 0) {

            throw new InvalidPriceException(
                    "Price must be greater than zero");
        }

        if (product.getQuantity() < 0) {

            throw new InvalidQuantityException(
                    "Invalid quantity");
        }

        return productDAO.update(product);
    }

    @Override
    public boolean deleteProduct(
            Long productId) {

        productDAO.findById(productId)
                .orElseThrow(() ->
                        new ProductNotFoundException(
                                "Product not found"));

        return productDAO.delete(productId);
    }

    @Override
    public Product getProductById(
            Long productId) {

        return productDAO
                .findById(productId)
                .orElseThrow(() ->
                        new ProductNotFoundException(
                                "Product not found with id : "
                                        + productId));
    }

    @Override
    public Product getProductByName(
            String productName) {

        return productDAO
                .findByName(productName)
                .orElseThrow(() ->
                        new ProductNotFoundException(
                                "Product not found : "
                                        + productName));
    }

    @Override
    public List<Product> getProductsByCategory(
            String category) {

        List<Product> products =
                productDAO.findByCategory(
                        category);

        if (products.isEmpty()) {

            throw new ProductNotFoundException(
                    "No products found in category : "
                            + category);
        }

        return products;
    }

    @Override
    public List<Product> getProductsByBrand(
            String brand) {

        List<Product> products =
                productDAO.findByBrand(
                        brand);

        if (products.isEmpty()) {

            throw new ProductNotFoundException(
                    "No products found for brand : "
                            + brand);
        }

        return products;
    }

    @Override
    public List<Product> getAllProducts() {

        List<Product> products =
                productDAO.findAll();

        if (products.isEmpty()) {

            throw new ProductNotFoundException(
                    "No products available");
        }

        return products;
    }

    @Override
    public List<Product> viewAvailableStock() {

        List<Product> products =
                productDAO.viewAvailableStock();

        if (products.isEmpty()) {

            throw new ProductOutOfStockException(
                    "All products are out of stock");
        }

        return products;
    }

    @Override
    public boolean updateStock(
            Long productId,
            Integer quantity) {

        productDAO.findById(productId)
                .orElseThrow(() ->
                        new ProductNotFoundException(
                                "Product not found"));

        if (quantity < 0) {

            throw new InvalidQuantityException(
                    "Invalid quantity");
        }

        return productDAO.updateStock(
                productId,
                quantity);
    }

    @Override
    public void addProductsBatch(
            List<Product> products) {

        try {

            productDAO.addProductsBatch(
                    products);

        } catch (SQLException e) {

            throw new DatabaseOperationException(
                    "Batch product import failed",
                    e);
        }
    }
}