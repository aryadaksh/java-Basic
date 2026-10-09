package com.service;

import java.util.List;

import com.exception.ProductNotFoundException;
import com.model.Product;
import com.repository.ProductRepository;


public class ProductService {

	 private ProductRepository repo;

	    public ProductService(ProductRepository repo) {
	        this.repo = repo;
	    }

	    public void addProduct(Product product) {
	        repo.addProduct(product);
	    }

	    public Product searchProductById(int id) throws ProductNotFoundException {
	        return repo.getProductById(id);
	    }

	    public List<Product> searchByCategory(String category) {
	        return repo.findByCategory(category);
	    }

	    public List<Product> viewAllProducts() {
	        return repo.getAllProducts();
	    }

}
