package com.spingbeanxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spingbeanxml.pojoclass.Employee;


public class App 
{
    public static void main( String[] args )
    {
        String pathConfig ="springbean.xml";
        ApplicationContext iocContainer = new ClassPathXmlApplicationContext(pathConfig);
        
        Employee employee =  (Employee) iocContainer.getBean("emp1");
        System.out.println("Id: "+employee.getId());
        System.out.println("Name: "+employee.getName());
        System.out.println("Address: "+employee.getAddress().getLine1()+" "+employee.getAddress().getLine2());
        System.out.println();
        Employee employee1 =  (Employee) iocContainer.getBean("emp2");
        System.out.println("Id: "+employee1.getId());
        System.out.println("Name: "+employee1.getName());
        System.out.println("Address: "+employee1.getAddress().getLine1()+" "+employee1.getAddress().getLine2());
    
        iocContainer = null;
    }
}
