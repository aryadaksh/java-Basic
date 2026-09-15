package com.comparatorexample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Driver {

	public static void main(String[] args) {

		List<Customer> customer = new ArrayList<Customer>();
		customer.add(new Customer(23, "Raza"));
		customer.add(new Customer(93, "Suman"));
		customer.add(new Customer(73, "Arya"));

		Collections.sort(customer, new CustomerByIdComparator());

		Iterator<Customer> itr = customer.iterator();
		while (itr.hasNext()) {
			Customer c = itr.next();
			System.out.println(c.customerId + " " + c.customerName);
		}

		System.out.println("===================================================================");
		Collections.sort(customer, new CustomerByNameComparator());

		Iterator<Customer> itr1 = customer.iterator();
		while (itr1.hasNext()) {
			Customer c = itr1.next();
			System.out.println(c.customerId + " " + c.customerName);
		}
	}

}
