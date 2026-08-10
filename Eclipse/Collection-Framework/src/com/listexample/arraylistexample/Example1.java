package com.listexample.arraylistexample;

import java.util.ArrayList;

public class Example1 {

	public static void main(String[] args) {
		
		
		//(100) means size of empName is 100
		ArrayList<String> empName = new ArrayList<String>(100);
	
		empName.add("Sandeep");
		empName.add("Raj");
		empName.add("Daksh");
		empName.add("Sandeep");
		empName.add("Raj");
		
//		for(int i = 0; i<empName.size(); i++) {
//			String name = empName.get(i);
//			if(name.startsWith("D")) {
//				System.out.println(name);
//			}
//		}
		
		//For each loop
		for(String it: empName) 
		{
			String name = it;
			if(name.startsWith("D")) {
				System.out.println(name);
			}
		}
		
		
	//	System.out.println(empName);
		

	}

}
