package com.flipkart.repository;



import java.util.ArrayList;
import java.util.List;

import com.flipkart.main.Product;

public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) { products.add(product); }
    public void updateProduct(Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId() == updatedProduct.getProductId()) {
                products.set(i, updatedProduct);
                return;
            }
        }
    }
    public void deleteProduct(int id) { products.removeIf(p -> p.getProductId() == id); }
    public Product getProductById(int id) {
        return products.stream().filter(p -> p.getProductId() == id).findFirst().orElse(null);
    }
    public List<Product> getAllProducts() { return products; }
}
