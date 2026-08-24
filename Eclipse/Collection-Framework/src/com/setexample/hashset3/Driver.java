package com.setexample.hashset3;

import java.util.HashSet;
import java.util.Set;

public class Driver {

	public static void main(String[] args) {
		Set<Order> order = new HashSet<Order>(2,1f);
		
		Order o1 = new Order("Iphone 16", 1);
		Order o2 = new Order("Iphone 17", 3);
		
		order.add(o1);
		order.add(o2);
		order.add(new Order("Iphone 16", 1));
		
		System.out.println(order.size());
		System.out.println(order);
	}
}
