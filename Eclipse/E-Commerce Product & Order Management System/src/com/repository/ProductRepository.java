package com.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.exception.ProductNotFoundException;
import com.model.Product;

public class ProductRepository /* extends Product */
{

	 private List<Product> products = new ArrayList<>();

	    public void addProduct(Product product) {
	        products.add(product);
	    }
	    
	    public void updateProduct(Product updatedProduct) {
	        for (int i = 0; i < products.size(); i++) {
	            if (products.get(i).getProductId() == updatedProduct.getProductId()) {
	                products.set(i, updatedProduct);
	                return;
	            }
	        }
	    }

	    public void deleteProduct(int id) {
	        products.removeIf(p -> p.getProductId() == id);
	    }

	    public Product getProductById(int id) throws ProductNotFoundException {
	        return products.stream()
	                       .filter(p -> p.getProductId() == id)
	                       .findFirst()
	                       .orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found"));
	    }

	    public List<Product> findByCategory(String category) {
	        return products.stream()
	                       .filter(p -> p.getCategory().equalsIgnoreCase(category))
	                       .collect(Collectors.toList());
	    }

	    public List<Product> getAllProducts() {
	        return products;
	    }

}
