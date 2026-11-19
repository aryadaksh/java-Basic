package com.amazon.fintech;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amazon.fintech.config.AppConfig;
import com.amazon.fintech.pojo.Delivery;

public class App 
{
    public static void main( String[] args )
    {
       
    	ApplicationContext iocContainer1 = new AnnotationConfigApplicationContext(AppConfig.class);
    	Delivery delivery1 = (Delivery) iocContainer1.getBean(Delivery.class);
    	System.out.println(delivery1.display());
    	
    	
    	Delivery delivery2 = (Delivery) iocContainer1.getBean(Delivery.class);
    	System.out.println(delivery2.display());
    	
    	System.out.println(delivery1 == delivery2);
    	
    }
}
