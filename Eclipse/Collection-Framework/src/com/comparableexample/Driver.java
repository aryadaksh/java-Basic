package com.comparableexample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Driver {
	
	public static void main(String[] args) {
		
		
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(100, "Mac20"));
		products.add(new Product(100, "Ipad23"));
		products.add(new Product(99, "S21FE"));
		products.add(new Product(5001, "Iphone 16 pro MAX"));
		
		Collections.sort(products);
		
		ListIterator<Product> itr = products.listIterator();
		
		while(itr.hasNext()) {
			Product p = itr.next();
			if(p.productName.equals("S21FE") ) {
				p = itr.previous();
				System.out.println(p.productName+" "+p.productId);
				break;
			}
			System.out.println(p.productId+" "+p.productName);
		}
		
	}

}
