package com.threadsyncblock;

public class Task {
	
	public /* synchronized */ void printOdd() {
		
		System.out.println("20 lines of code .....");
		
		synchronized (this) {
			
		
		
		for(int i = 0; i<10; i++) {
			if(i % 2 != 0) {
				System.out.println(i +" ["+Thread.currentThread().getName()+"]");
			}
		}
		}
		System.out.println("20 lines of code .....");
	}
	
	/*
	 * public synchronized void printEven() { for(int i = 0; i<10; i++) { if(i % 2
	 * != 0) { System.out.println(i +" ["+Thread.currentThread().getName()+"]"); } }
	 * }
	 */

}