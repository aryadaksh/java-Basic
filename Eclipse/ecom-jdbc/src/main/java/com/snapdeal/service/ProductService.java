package com.snapdeal.service;

import java.util.List;

import com.snapdeal.model.Product;

public interface ProductService {

    boolean addProduct(Product product);

    boolean updateProduct(Product product);

    boolean deleteProduct(Long productId);

    Product getProductById(Long productId);

    Product getProductByName(String productName);

    List<Product> getProductsByCategory(String category);

    List<Product> getProductsByBrand(String brand);

    List<Product> getAllProducts();

    List<Product> viewAvailableStock();

    boolean updateStock(Long productId,
                        Integer quantity);
    
    void addProductsBatch(List<Product> products);
}