package com.threadusing1;

public class Drivevr {
	
	public static void main(String[] args) {
		
		Task task = new Task();
		
		PrintThread t1 = new PrintThread(task);
		t1.start();
		
		PrintThread1 t2 = new PrintThread1(task);
		t2.start();
	}

}
