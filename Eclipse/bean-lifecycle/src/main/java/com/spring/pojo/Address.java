package com.spring.pojo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Address implements InitializingBean, DisposableBean
{
	
	private static final Logger log = LogManager.getLogger();
	
	private String line1;
	private String line2;
	public Address(String line1, String line2) {
		log.info("Step 1 of bean definition");
		log.info(" this is inside constructor this run during bean");
		
		this.line1 = line1;
		this.line2 = line2;
	}
	
	@PostConstruct
	public void init() {
		
		log.info("This is @PostConstruct this will run after the bean definiton for intilization");
		System.out.println("Address.init()");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("this will verify that @PostConstruct method is initlized everything corretly or not");
		System.out.println("Address.afterPropertiesSet()");
	}
	
	public void display() {
		log.info("This is address class inside the method display ");
		System.out.println( "Address [line1=" + line1 + ", line2=" + line2 + "]");
		
	}
	
	@PreDestroy
	public void cleanUp() {
	
		log.info("This will cleanup the intilize after the container call its clean() method");
	
		System.out.println("Address.cleanUp()");
	}

	@Override
	public void destroy() throws Exception {
		log.info("this will verify that the cleanup is happened correctly or not");
	
		System.out.println("Address.destroy()");
	}

	
	
	

}
