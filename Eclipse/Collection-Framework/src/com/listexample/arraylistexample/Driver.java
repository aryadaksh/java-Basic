package com.listexample.arraylistexample;

import java.util.ArrayList;


/*
 * Collection - > 
 * 1.List -> duplicates and ordered
 * 2.Set -> unorderded and unqiue
 * 
 * 1.list -> ArrayList
 */

public class Driver {

	public static void main(String[] args) {
		
		ArrayList<String> employeeName = new ArrayList<String>();
		
		employeeName.add("Sachin");
		employeeName.add("Sandeep");
		employeeName.add("Sandeep");
		employeeName.add("Vivek");
		employeeName.add("Daksh");
		
		System.out.println(employeeName);
		
		
		
	}
}
