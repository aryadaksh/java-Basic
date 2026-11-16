package com.spingdifieldinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spingdifieldinjection.bean.Employee;
import com.spingdifieldinjection.config.SpringConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	ApplicationContext iocContainer = new AnnotationConfigApplicationContext(SpringConfig.class);
    	
    	Employee emp = (Employee) iocContainer.getBean("emp");
    	
    	System.out.println(emp.displayDetails());
    	
    }
}
