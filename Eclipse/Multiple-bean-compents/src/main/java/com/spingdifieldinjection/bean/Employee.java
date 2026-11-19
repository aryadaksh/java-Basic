package com.spingdifieldinjection.bean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Employee {
	
	private static final Logger log = LogManager.getLogger(Employee.class);
	
	private String firstName;
	private String lastName;
	private String empId;
	public Employee(String firstName, String lastName, String empId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.empId = empId;
	}
	
	
	public void display() {
		
		log.info("THis is employee class display method Start");
		
		System.out.println("Name: "+firstName+" "+lastName);
		System.out.println("EmpId:"+empId);
		
		log.info("THis is employee class display method ENd");
	}
	

}
