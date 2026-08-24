package com.setexample.hashset3;

public class Order {
	
	private String product;
	private int qty;
	
	public Order(String product,int qty) 
	{
		this.product = product;
		this.qty = qty;
	}
	
	public int hashCode() {
		return this.product.hashCode()+this.qty;
	}
	
	public boolean equals(Object obj) {
		Order ord = (Order) obj;
		return  this.product.equals(ord.product) & this.qty == ord.qty;
	}
	
	@Override
	public String toString() {
		return   product + " " + qty ;
	}

}
