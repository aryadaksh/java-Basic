package com.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Product {
	
	private  final static  AtomicInteger  UNIQUE_ID = new AtomicInteger(9000);

	// Instance Variable
	private int productId;
	private String productName;
	private String category;
	private double price;
	private int quantity;
	private String brandName;
	public Product(
			 String productName, String	 category, double price, int quantity, String brandName) {
		super();
		 this.productId = UNIQUE_ID.incrementAndGet(); 
		this.productName = productName;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		this.brandName = brandName;
	}
	
	

	

	

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
	    this.quantity = quantity;
	}


	protected void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	// constructors 
	

	// get for Instance varible 
	

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public String getCategory() {
		return category;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getBrandName() {
		return brandName;
	}
	
	
	@Override
    public String toString() {
        return productId + " - " + productName + " (" + category + ") Rs." + price;
    }

	
}
