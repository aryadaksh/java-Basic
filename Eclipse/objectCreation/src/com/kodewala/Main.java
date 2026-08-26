package com.kodewala;




abstract  class Animal {

	
	
	abstract void eat();
	
	public static void main(String[] args) {
		
	}
	
	
	
	
}

class Dog extends Animal{

	@Override
	void eat() {
		System.out.println("Dog.eat()");
		
	}
	
}

class Cat extends Animal{

	@Override
	void eat() {
		System.out.println("Cat.eat()");
		
	}
	
}

public class Main {
	
	
	
	
	
//	public Main() {
//		super();
//	}

	public static void main(String[] args) {
		
		
	}

}
