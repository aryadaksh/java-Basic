package com.streamapi3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class Empolyee{
	String name;
	int salary;
	public Empolyee(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public int getSalary() {
		return salary;
	}
	
	public String toString() {
		return name +" "+salary;
	}
	
}
public class SecondHighestSalaryOfEmployee {
	
	public static void main(String[] args) {
		List<Empolyee> employees = Arrays.asList( new Empolyee("Daksh", 12000),
	            new Empolyee("Amit", 15000),
	            new Empolyee("Riya", 12000),
	            new Empolyee("Karan", 18000),
	            new Empolyee("Sneha", 15000),
	            new Empolyee("Vikas", 20000),
	            new Empolyee("Meera", 12000),
	            new Empolyee("Arjun", 18000),
	            new Empolyee("Neha", 15000),
	            new Empolyee("Rohan", 20000),
	            new Empolyee("Priya", 12000),
	            new Empolyee("Suresh", 15000),
	            new Empolyee("Anita", 18000),
	            new Empolyee("Manish", 20000),
	            new Empolyee("Pooja", 12000),
	            new Empolyee("Rahul", 15000),
	            new Empolyee("Komal", 18000),
	            new Empolyee("Deepak", 20000),
	            new Empolyee("Shivani", 12000),
	            new Empolyee("Varun", 15000));
		
		/*
		 * Empolyee result = employees.stream().sorted((e1,e2) ->
		 * Integer.compare(e2.getSalary(), e1.getSalary())).skip(1).findFirst().get();
		 * 
		 * System.out.println(result.getName() +" "+result.getSalary());
		 */
		
		Optional<Empolyee> secoHigh = employees.stream()
			    .sorted(Comparator.comparing(Empolyee::getSalary).reversed())
			    .map(Empolyee::getSalary)              // focus only on salary values
			    .distinct()                            // remove duplicate salaries
			    .skip(1)                               // skip the highest
			    .findFirst()                           // get the second highest salary
			    .flatMap(sal -> employees.stream()
			        .filter(e -> e.getSalary() == sal) // find employee(s) with that salary
			        .findFirst());                     // pick one employee

		
		if(secoHigh.isPresent()) {
			System.out.println(secoHigh.get());
		}
	}

}
