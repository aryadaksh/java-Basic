package com.snapdeal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.snapdeal.dao.ProductDAO;
import com.snapdeal.model.Product;
import com.snapdeal.util.DBConnection;

public class ProductDAOImpl implements ProductDAO {

    private static final String INSERT =
            "INSERT INTO products(product_name,category,price,quantity,brand) VALUES(?,?,?,?,?)";

    private static final String UPDATE =
            "UPDATE products SET product_name=?, category=?, price=?, quantity=?, brand=? WHERE product_id=?";

    private static final String DELETE =
            "DELETE FROM products WHERE product_id=?";

    private static final String FIND_BY_ID =
            "SELECT * FROM products WHERE product_id=?";

    private static final String FIND_BY_NAME =
            "SELECT * FROM products WHERE LOWER(product_name) LIKE LOWER(?)";

    private static final String FIND_BY_CATEGORY =
            "SELECT * FROM products WHERE LOWER(category) LIKE LOWER(?)";

    private static final String FIND_BY_BRAND =
            "SELECT * FROM products WHERE LOWER(brand) LIKE LOWER(?)";

    private static final String FIND_ALL =
            "SELECT * FROM products";

    private static final String AVAILABLE_STOCK =
            "SELECT * FROM products WHERE quantity > 0";

    private static final String UPDATE_STOCK =
            "UPDATE products SET quantity=? WHERE product_id=?";

    private static final String REDUCE_STOCK =
            "UPDATE products SET quantity = quantity - ? WHERE product_id=?";

    private static final String INCREASE_STOCK =
            "UPDATE products SET quantity = quantity + ? WHERE product_id=?";

    private Product mapProduct(ResultSet rs)
            throws SQLException {

        Product product = new Product();

        product.setProductId(
                rs.getLong("product_id"));

        product.setProductName(
                rs.getString("product_name"));

        product.setCategory(
                rs.getString("category"));

        product.setPrice(
                rs.getBigDecimal("price"));

        product.setQuantity(
                rs.getInt("quantity"));

        product.setBrand(
                rs.getString("brand"));

        return product;
    }

    @Override
    public boolean save(Product product) {

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(INSERT)) {

            ps.setString(1, product.getProductName());
            ps.setString(2, product.getCategory());
            ps.setBigDecimal(3, product.getPrice());
            ps.setInt(4, product.getQuantity());
            ps.setString(5, product.getBrand());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean update(Product product) {

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(UPDATE)) {

            ps.setString(1, product.getProductName());
            ps.setString(2, product.getCategory());
            ps.setBigDecimal(3, product.getPrice());
            ps.setInt(4, product.getQuantity());
            ps.setString(5, product.getBrand());
            ps.setLong(6, product.getProductId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(Long productId) {

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(DELETE)) {

            ps.setLong(1, productId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Optional<Product> findById(Long productId) {

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(FIND_BY_ID)) {

            ps.setLong(1, productId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return Optional.of(
                        mapProduct(rs));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public Optional<Product> findByName(String productName) {

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(FIND_BY_NAME)) {

        	ps.setString(
        	        1,
        	        "%" + productName + "%");

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return Optional.of(
                        mapProduct(rs));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public List<Product> findByCategory(String category) {

        List<Product> products = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(FIND_BY_CATEGORY)) {

        	ps.setString(
        	        1,
        	        "%" + category + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                products.add(
                        mapProduct(rs));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return products;
    }

    @Override
    public List<Product> findByBrand(String brand) {

        List<Product> products = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(FIND_BY_BRAND)) {

        	ps.setString(
        	        1,
        	        "%" + brand + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                products.add(
                        mapProduct(rs));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return products;
    }

    @Override
    public List<Product> findAll() {

        List<Product> products = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(FIND_ALL);

             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                products.add(
                        mapProduct(rs));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return products;
    }

    @Override
    public List<Product> viewAvailableStock() {

        List<Product> products = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(AVAILABLE_STOCK);

             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                products.add(
                        mapProduct(rs));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return products;
    }

    @Override
    public boolean updateStock(Long productId,
                               Integer quantity) {

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(UPDATE_STOCK)) {

            ps.setInt(1, quantity);
            ps.setLong(2, productId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean reduceStock(Long productId,
                               Integer quantity,
                               Connection connection) {

        try (PreparedStatement ps =
                     connection.prepareStatement(REDUCE_STOCK)) {

            ps.setInt(1, quantity);
            ps.setLong(2, productId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean increaseStock(Long productId,
                                 Integer quantity,
                                 Connection connection) {

        try (PreparedStatement ps =
                     connection.prepareStatement(INCREASE_STOCK)) {

            ps.setInt(1, quantity);
            ps.setLong(2, productId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return false;
    }
    

public void addProductsBatch(List<Product> products)
        throws SQLException {

    String sql = "INSERT INTO products "
            + "(product_name, category, price, quantity, brand) "
            + "VALUES (?, ?, ?, ?, ?)";

    try (Connection con = DBConnection.getConnection()) {

        con.setAutoCommit(false);

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            for (Product product : products) {

                ps.setString(1, product.getProductName());
                ps.setString(2, product.getCategory());
                ps.setBigDecimal(3, product.getPrice());
                ps.setInt(4, product.getQuantity());
                ps.setString(5, product.getBrand());

                ps.addBatch();
            }

            ps.executeBatch();
            con.commit();

        } catch (SQLException e) {
            con.rollback();
            throw e;
        }
    }
}

}