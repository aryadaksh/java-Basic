package com.setexample.treeset1;

import java.util.Set;
import java.util.TreeSet;

public class Driver {
	public static void main(String[] args) {
		Set<Integer> numbers = new TreeSet<Integer>();
		numbers.add(1);
		numbers.add(432);
		numbers.add(-231);
		numbers.add(56789);
		numbers.add(0);
		
		System.out.println(numbers);
	}

}
