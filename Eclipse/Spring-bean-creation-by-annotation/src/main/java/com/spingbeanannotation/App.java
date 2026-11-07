package com.spingbeanannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pojoclass.Employee;
import com.spingbeanannotation.config.SpringConfig;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Spring bean Creation using Annotation" );
        ApplicationContext ioc = new AnnotationConfigApplicationContext(SpringConfig.class);
        
        Employee emp = ioc.getBean(Employee.class);
        
        System.out.println(emp.toString());
        
    }
}
