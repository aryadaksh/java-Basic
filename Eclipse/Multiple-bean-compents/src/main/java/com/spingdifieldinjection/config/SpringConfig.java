package com.spingdifieldinjection.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.spingdifieldinjection.bean.Employee;

@Configuration
@ComponentScan(basePackages = "com.spingdifieldinjection")
public class SpringConfig {
	
	@Bean("emp1")
	@Primary
	public Employee employee1() {
		
		return new Employee("Daksh", "Arya", "emp123");
	}
	
	@Bean("emp2")
	//@Primary
	public Employee employee2() {
		
		return new Employee("Daiwik", "Arya", "emp321");
	}

}
