package com.amazon.fintech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.amazon.fintech.pojo.Delivery;

@Configuration
public class AppConfig {
	
	@Bean("del")
	/*
	 * @Scope("singleton")
	 * 
	 * @Scope("prototype")
	 * 
	 * @Scope("request")
	 * 
	 * @Scope("session")
	 * 
	 * @Scope("application")
	 */
	public Delivery createBeanDelivery() {
		return new Delivery("On-Hold", "d123", "cus321");
	}

}
