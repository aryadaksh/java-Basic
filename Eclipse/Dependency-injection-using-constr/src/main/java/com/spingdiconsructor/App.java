package com.spingdiconsructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spingdiconsructor.beaninjections.Employee;
import com.spingdiconsructor.config.SpringConfig;

/**
 * Depencdy Injection using Constructor
 * 1.its  immutable
 * 2.its  mandatory
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //
    	ApplicationContext ioc = new AnnotationConfigApplicationContext(SpringConfig.class);
    	
    	Employee emp = ioc.getBean(Employee.class);
    	
    	System.out.println(emp.displayDetails());
    	
    }
}
