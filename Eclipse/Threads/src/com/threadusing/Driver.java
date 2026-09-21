
package com.threadusing;

public class Driver {
	
	public static void main(String[] args) {
		
		System.out.println("Main Started ["+Thread.currentThread().getName()+"]");
		
		Task task = new Task();
		
		PrintThread t1 = new PrintThread(task);
		t1.setName("FirstThread");
		t1.start();
		
		PrintThread t2 = new PrintThread(task);
		t2.setName("SecondThread");
		t2.start();
		
		System.out.println("Main Ended ["+Thread.currentThread().getName()+"]");
		
	}

}
