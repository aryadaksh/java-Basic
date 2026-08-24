package com.setexample.treeset2;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

class Product implements Comparable<Product>
{
	String productName;

	public Product(String productName) {
		super();
		this.productName = productName;
	}

	

	@Override
	public int compareTo(Product o) {
		
		return this.productName.compareTo(o.productName);
	}

	
	public String toString() {
		return this.productName;
	}
	
	
}

public class Driver {
	
	public static void main(String[] args) {
		Set<Product> pName = new TreeSet<Product>();
		
		pName.add(new Product("Iphone"));
		pName.add(new Product("Mac"));
		pName.add(new Product("Ipad"));
		pName.add(new Product("Pc"));
		
	//	System.out.println(pName);
		
		
//		for (Product product : pName) {
//			System.out.println(product.productName);
//		}
		
		Iterator<Product> prodName = pName.iterator();
		while(prodName.hasNext()) {
			Product p = prodName.next();
			System.out.println(p);
		}
//	 	
	}

}
