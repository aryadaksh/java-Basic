package com.spingdisetter.Depencdency_injection_usuing_setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spingdisetter.bean.Employee;
import com.spingdisetter.config.SpringConfig;

/**
 * Dependecy Injecetion- using setter
 * 1.it is muttable
 * 2.its optional
 *
 */
public class App {
	public static void main(String[] args) {

		ApplicationContext iocContainer = new AnnotationConfigApplicationContext(SpringConfig.class);
		Employee emp = iocContainer.getBean(Employee.class);

		System.out.println(emp.displayDetails());

	}
}
