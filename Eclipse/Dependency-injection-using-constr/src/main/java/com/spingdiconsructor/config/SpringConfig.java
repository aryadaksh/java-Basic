package com.spingdiconsructor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spingdiconsructor.beaninjections.Address;
import com.spingdiconsructor.beaninjections.Employee;

@Configuration
public class SpringConfig {
	
	
	@Bean
	public Address address() {
		return new Address("9 th cross ", "Btm First", "Blr");
	}
	
	
	@Bean
	public Employee employee() {
		return new Employee("Daksh Arya", "Arya", "Ep123", address());
	}
	

}
