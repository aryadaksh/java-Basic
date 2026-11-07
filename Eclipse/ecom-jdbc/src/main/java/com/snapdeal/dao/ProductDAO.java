package com.snapdeal.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.snapdeal.model.Product;

public interface ProductDAO {

    boolean save(Product product);

    boolean update(Product product);

    boolean delete(Long productId);

    Optional<Product> findById(Long productId);

    Optional<Product> findByName(String productName);

    List<Product> findByCategory(String category);

    List<Product> findByBrand(String brand);

    List<Product> findAll();

    List<Product> viewAvailableStock();

    boolean updateStock(Long productId,
                        Integer quantity);

    boolean reduceStock(Long productId,
                        Integer quantity,
                        Connection connection);

    boolean increaseStock(Long productId,
                          Integer quantity,
                          Connection connection);
    public void addProductsBatch(List<Product> products) throws SQLException;
}