package com.setexample.treeset2.cw;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Driver {
	
	public static void main(String[] args) {
		
		Product p1 = new Product("Iphone", "pId123", 500, true);
		Product p2 = new Product("Samsung", "pId321", 1000, false);
		Product p4 = new Product("Samsung12", "pId213", 1000, false);
		Product p3 = new Product("Samsung1", "pId321", 200, true);
		
		Set<Product> prHash = new HashSet<Product>();
		
		prHash.add(p1);
		prHash.add(p2);
		prHash.add(p3);
		prHash.add(p4);
		Set<Product> pSet= new TreeSet<Product>();
		
		pSet.addAll(prHash);
		
		Iterator<Product> pro = pSet.iterator();
		
		while(pro.hasNext()) {
			Product p = (Product)pro.next();
			System.out.println(p.getPrice()+" "+p.getProductId()+" "+p.getProductName()+" "+p.isStatus());
		}
		
	}

}
