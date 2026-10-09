package com.flipkart.service;



import java.util.List;
import java.util.stream.Collectors;

import com.flipkart.main.Product;
import com.flipkart.repository.ProductRepository;

public class ProductService {
    private ProductRepository repo;

    public ProductService(ProductRepository repo) { this.repo = repo; }

    public void addProduct(Product product) { repo.addProduct(product); }
    public List<Product> viewAllProducts() { return repo.getAllProducts(); }
    public Product searchById(int id) { return repo.getProductById(id); }

    public List<Product> searchByName(String name) {
        return repo.getAllProducts().stream()
                   .filter(p -> p.getProductName().equalsIgnoreCase(name))
                   .collect(Collectors.toList());
    }

    public List<Product> searchByCategory(String category) {
        return repo.getAllProducts().stream()
                   .filter(p -> p.getCategory().equalsIgnoreCase(category))
                   .collect(Collectors.toList());
    }

    public List<Product> searchByBrand(String brand) {
        return repo.getAllProducts().stream()
                   .filter(p -> p.getBrand().equalsIgnoreCase(brand))
                   .collect(Collectors.toList());
    }

    public List<Product> searchByPriceRange(double min, double max) {
        return repo.getAllProducts().stream()
                   .filter(p -> p.getPrice() >= min && p.getPrice() <= max)
                   .collect(Collectors.toList());
    }

    public void updatePrice(int id, double newPrice) {
        Product p = repo.getProductById(id);
        if (p != null) p.setPrice(newPrice);
    }

    public void updateQuantity(int id, int newQty) {
        Product p = repo.getProductById(id);
        if (p != null) p.setQuantity(newQty);
    }

    public void deleteProduct(int id) { repo.deleteProduct(id); }
}
