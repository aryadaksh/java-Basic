package com.spring.pojo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressMgmt {
	
	private static final Logger log = LogManager.getLogger();
	
	@Autowired
	Address address;
	
	
	public void disDetails() {
		log.info("This is AddressMgmt class inside the method disDetails  Start");
		address.display();
		log.info("This is AddressMgmt class inside the method disDetails  End");
		
	}

}
