package com.spring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.spring.config.AppConfig;
import com.spring.pojo.AddressMgmt;

public class App 
{
	private static final Logger log = LogManager.getLogger();
	
    public static void main( String[] args )
    {
        log.info("This is main app this will run its will create the iocContainer");
        
        ApplicationContext iocCotainer = new AnnotationConfigApplicationContext(AppConfig.class);
        
        AddressMgmt address = iocCotainer.getBean(AddressMgmt.class);
        address.disDetails();
        ((AbstractApplicationContext) iocCotainer).close();
    }
}
