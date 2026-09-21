package com.threadimplements1;

// Second way to create new thread 

class Task implements Runnable
{

	@Override
	public void run() {
		System.out.println("Task.run() "+Thread.currentThread().getName());
		
	}
	
}

public class Driver {

	public static void main(String[] args) {
		
		System.out.println("Main Started "+Thread.currentThread().getName());
		
		Task task = new Task();
		Thread t1 = new Thread(task);
		t1.start();
		
		System.out.println("Main Ended "+Thread.currentThread().getName());
	}
}
