package com.spingdifieldinjection.magmt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.spingdifieldinjection.bean.Employee;

@Component
public class EmployeeMgmt {
	
	private static final Logger log = LogManager.getLogger(EmployeeMgmt.class);
	
	@Autowired
	// @Qualifier("emp2")
	Employee employee;
	
	public void display() {
		
		log.info("Start the display of empMgmt");
		
		employee.display();
		
		log.info("End the display of empMgmt");
		
	}

}
