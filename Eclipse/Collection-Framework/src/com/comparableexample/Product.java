package com.comparableexample;

public class Product implements Comparable<Product>
{
	
	int productId;
	String productName;
	public Product(int productId, String productName) {
		super();
		this.productId = productId;
		this.productName = productName;
	}
	@Override
	public int compareTo(Product p) {
		int result = Integer.compare(p.productId, this.productId);
		if(result == 0) {
			result = this.productName.compareTo(p.productName);
		}
		return result;
	}
	
	

}
