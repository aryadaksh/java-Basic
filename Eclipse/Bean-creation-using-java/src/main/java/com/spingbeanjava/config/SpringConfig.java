package com.spingbeanjava.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pojoclass.Address;
import com.pojoclass.Employee;

@Configuration
public class SpringConfig {
	
	@Bean("add1")
	public Address createAddBean1() {
		
		Address add = new Address("BTM", "Blr");
		
		return add;
		
	}
	
	@Bean("add2")
	public Address createAddBean2() {
		
		Address add = new Address("BSF", "BIH");
		
		return add;
		
	}
	
	
	@Bean("emp1")
	public Employee createEmpBean1(@Qualifier("add1") Address createAddBean1) {
		
		Employee emp = new Employee();
		emp.setName("Daksh");
		emp.setId("D123");
		
		// injecting bean creation
		emp.setAddress(createAddBean1);
		
		
		return emp;
		
	}
	
	@Bean("emp2")
	public Employee createEmpBean2(@Qualifier("add2") Address createAddBean2) {
		
		Employee emp = new Employee();
		emp.setName("Arya");
		emp.setId("D321");
		
		// Injecting bean Creation
		emp.setAddress(createAddBean2);
		
		
		
		return emp;
		
	}

}
