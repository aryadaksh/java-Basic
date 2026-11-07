package com.spingbeanjava;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pojoclass.Employee;
import com.spingbeanjava.config.SpringConfig;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Creating Bean Using java" );
        
        @SuppressWarnings("resource")
		ApplicationContext iocConatiner = new AnnotationConfigApplicationContext(SpringConfig.class);
        
        
        System.out.println();
        Employee emp1 = (Employee) iocConatiner.getBean("emp1");
        System.out.println("Employee Name: "+emp1.getName());
        System.out.println("Employee Id: "+emp1.getId());
        System.out.println("Employee Address: "+emp1.getAddress().getLine1()+" "+emp1.getAddress().getLine2());
        
        
        System.out.println();
        
        
        Employee emp2 = (Employee) iocConatiner.getBean("emp2");
        System.out.println("Employee Name: "+emp2.getName());
        System.out.println("Employee Id: "+emp2.getId());
        System.out.println("Employee Address: "+emp2.getAddress().getLine1()+" "+emp2.getAddress().getLine2());
    }
}
