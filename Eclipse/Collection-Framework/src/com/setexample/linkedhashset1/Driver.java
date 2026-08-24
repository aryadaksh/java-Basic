package com.setexample.linkedhashset1;

import java.util.LinkedHashSet;
import java.util.Set;

public class Driver {
	
	public static void main(String[] args) {
		Set<String> cityName = new LinkedHashSet<String>();
		cityName.add("Kolkata");
		cityName.add("Raipur");
		cityName.add("Patna");
		cityName.add("Delhi");
		cityName.add("Chennai");
		cityName.add("Patna");
		
		System.out.println(cityName);
		
		
	}

}
