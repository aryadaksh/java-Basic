package com.collectionsutilityexample.methods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Driver {
	
	public static void main(String[] args) {
		
		List<String> cities = new ArrayList<String>();
		
		cities.add("Kolkata");
		cities.add("Patna");
		cities.add("Hyd");
		cities.add("Mysore");
		
		System.out.println(cities);
		
		Collections.sort(cities);
		
		System.out.println(cities);
		
		List<String> readOnlyCity =  Collections.unmodifiableList(cities);
		//readOnlyCity.add("BSF");
		System.out.println(readOnlyCity);
		
		//thread safe
		List<String> threadSafeCity = Collections.synchronizedList(cities);
		System.out.println(threadSafeCity);
		
		Collections.reverse(cities);
		System.out.println(cities);
		
		Collections.shuffle(cities);
		System.out.println(cities);
	}

}
