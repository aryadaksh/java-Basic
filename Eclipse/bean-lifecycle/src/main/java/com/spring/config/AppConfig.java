package com.spring.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.spring.pojo.Address;
import com.spring.pojo.AddressMgmt;

@Configuration
@ComponentScan(basePackageClasses = AddressMgmt.class)
public class AppConfig {
	private static final Logger log = LogManager.getLogger();
	
	@Bean
	public Address address() {
		log.info("THis is AppConfig class here bean defintion happens");
		return new Address("Btm 1st", "BLr");
	}

}
