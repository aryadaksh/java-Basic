package com.spingdisetter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spingdisetter.bean.Address;
import com.spingdisetter.bean.Employee;

@Configuration
public class SpringConfig {
	
	
	@Bean
	public Address address() {
		return new Address("9 th cross ", "Btm First", "Blr");
	}
	
	
	@Bean
	public Employee employee() {
		Employee emp = new Employee("Daksh Arya", "Arya", "Ep123" );
		emp.setAddress(address());
		
		return emp;
	}
	

}