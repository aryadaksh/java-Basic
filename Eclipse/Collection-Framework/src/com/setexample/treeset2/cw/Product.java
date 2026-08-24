package com.setexample.treeset2.cw;

import java.util.Objects;

public class Product implements Comparable<Product>
{
	
	private String productName;
	private String productId;
	private int price;
	private boolean status;
	public Product(String productName, String productId, int price, boolean status) {
		super();
		this.productName = productName;
		this.productId = productId;
		this.price = price;
		this.status = status;
	}
	public String getProductName() {
		return productName;
	}
	public String getProductId() {
		return productId;
	}
	public int getPrice() {
		return price;
	}
	public boolean isStatus() {
		return status;
	}
	@Override
	public int compareTo(Product o) {
		int result = Integer.compare(this.price, o.price);

	    if (result == 0) {
	        result = this.productId.compareTo(o.productId);
	    }

		
		return result;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(productId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(productId, other.productId);
	}
	
	

}
