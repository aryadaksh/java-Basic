package com.listexample.arraylistclass2;

import java.util.ArrayList;


/*
 * In list -> O(1) is for reading the elements with the index based
 * if we try to do adding / and removing the elements  from ARRAYLIST  "other than the last index of ArrayList" its will O(n) 
 */

public class Driver {

	public static void main(String[] args) {
		
		CityName name = new CityName();
		
		//ArrayList nameCity =
				name.getCitiesName();
				
				name.getCitiesName().add(3, "Raj");
				
				System.out.println(name.getCitiesName());
		
		//System.out.println(nameCity);
		
	//	nameCity.add(4, nameCity);
		
		//System.out.println(nameCity);
		
		//System.out.println(nameCity);
		
	}
}
