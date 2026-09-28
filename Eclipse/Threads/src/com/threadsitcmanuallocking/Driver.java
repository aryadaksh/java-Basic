package com.threadsitcmanuallocking;

public class Driver {
	
	public static void main(String[] args) {
		
		/* ReentrantLock lock = new ReentrantLock(); */
		
		Task task = new Task();
		/* Task task2 = new Task(); */
		
		/*
		 * Producer produce = new Producer(lock -> {
		 * 
		 * }); produce.start();
		 */
		
		Consumer consume = new Consumer(task);
		consume.start();
		
		Producer produce = new Producer(task);
		produce.start();
		
		
		
	}

}
