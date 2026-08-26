package com.concurrentmodificationexcaption.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		List<String> cities = new ArrayList<String>();

		cities.add("Kolkata");
		cities.add("Patna");	
		cities.add("Hyd");
		cities.add("Mysore");
		
		Iterator<String> itr = cities.iterator();
		while (itr.hasNext()) {
			String elements =  itr.next();
			System.out.println(elements);
			
			//In iterator doing adding or removing will throw ConcurrentModificationException
		//	cities.add("Raj");
			if(elements == "Hyd") {
			cities.remove("Hyd");
			}
			
		}
	}
}
