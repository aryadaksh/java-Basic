package com.setexample.hashcode1;

class A{
	String name;
	public A(String name) {
		name = name;
	}
}

public class Driver {
	
	public static void main(String[] args) {
		
		A a1 = new A("Rahul");
		A a2 = new A("Rahul");
		
		System.out.println(a1 == a2);
		System.out.println(a1.hashCode()+ " "+ a2.hashCode());
		
	}

}
