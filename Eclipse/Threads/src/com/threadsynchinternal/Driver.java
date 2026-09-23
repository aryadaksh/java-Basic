package com.threadsynchinternal;

public class Driver {
	
	public static void main(String[] args) {
		Task task = new Task(); // lock 1
		PrintThread printThread = new PrintThread(task);
		Thread t1 = new Thread(printThread);
	//	t1.stop();
		t1.start(); 
		
		/*
		 * PrintThread printThread = new PrintThread(task);
		 */		Thread t2 = new Thread(printThread);
		t2.start();
		
	}

}
