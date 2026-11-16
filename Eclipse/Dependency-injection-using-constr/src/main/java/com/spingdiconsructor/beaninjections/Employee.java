package com.spingdiconsructor.beaninjections;

public class Employee {
	
	private String firstName;
	private String lastName;
	private String empId;
	
	private Address address;

	public Employee(String firstName, String lastName, String empId, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.empId = empId;
		this.address = address;
	}

	
	public String displayDetails() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", empId=" + empId + ", address="
				+ address.displayAddress() + "]";
	}
	
	

}
