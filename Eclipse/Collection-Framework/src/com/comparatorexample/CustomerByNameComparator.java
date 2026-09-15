package com.comparatorexample;

import java.util.Comparator;

public class CustomerByNameComparator implements Comparator<Customer>
{
	public int compare(Customer c1,Customer c2) {
		int result = c1.customerName.compareTo(c2.customerName);
		return result;
	}

}
