package com.listexample.linkedlistclass1;

import java.util.LinkedList;

public class Driver {

	public static void main(String[] args) {
		
		LinkedList<String> cityName = new LinkedList<String>();
		
		cityName.add("BEN");
		cityName.add("CHE");
		cityName.add("HYD");
		cityName.add("DEL");
		cityName.add("MUM");
		cityName.add("DEL");
		
		System.out.println(cityName);
		
		// O(n)
		System.out.println(cityName.get(3));
		
		// O(1) to add + O(n) to tervers to that n here n-> 3
		cityName.add(3,"JAI");
		
	}
}
