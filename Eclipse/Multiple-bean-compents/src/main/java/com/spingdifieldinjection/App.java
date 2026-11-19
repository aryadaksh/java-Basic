package com.spingdifieldinjection;

import org.apache.logging.log4j.LogManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spingdifieldinjection.config.SpringConfig;
import com.spingdifieldinjection.magmt.EmployeeMgmt;


public class App 
{
	private static final org.apache.logging.log4j.Logger log = LogManager.getLogger(App.class);
	
    public static void main( String[] args )
    {
    	log.info("This is main App Start");
    	
       ApplicationContext ioc = new AnnotationConfigApplicationContext(SpringConfig.class);
       EmployeeMgmt employeeMgmt = ioc.getBean(EmployeeMgmt.class);
       
       employeeMgmt.display();
       
       log.info("This is main App END");
    }
}
