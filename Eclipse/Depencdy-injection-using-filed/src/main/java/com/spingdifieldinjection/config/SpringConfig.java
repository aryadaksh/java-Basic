package com.spingdifieldinjection.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spingdifieldinjection.bean.Address;
import com.spingdifieldinjection.bean.Employee;

@Configuration
public class SpringConfig {
	
	@Bean
	public Address address() {
		return new Address("9th Cross", "Btm", "BLR");
		
	}
	
	@Bean("emp")
	public Employee employee() {
		return new Employee("Daksh ", "Arya", "Emp123");
	}

}
