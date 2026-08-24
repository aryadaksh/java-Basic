package com.setexample.treeset1;

import java.util.Set;
import java.util.TreeSet;

public class Employee implements Comparable<Employee>
{
	
	private String name;
	public Employee(String name) {
		this.name= name;
	}
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}



	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
	}

}

class MainApp{
	public static void main(String[] args) {
		Set<Employee> empObj = new TreeSet<Employee>();
		empObj.add(new Employee("Daksh"));
		empObj.add(new Employee("Masood"));
		empObj.add(new Employee("Paju"));
		
		//empObj("Daksh");
		
		System.out.println(empObj);
	}
}
