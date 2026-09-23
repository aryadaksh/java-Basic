package com.threadsynchinternal;

public class Task {
	
	public synchronized void printOdd() {
		for(int i = 0; i<10; i++) {
			if(i % 2 != 0) {
				System.out.println(i +" ["+Thread.currentThread().getName()+"]");
			}
		}
	}
	
	/*
	 * public synchronized void printEven() { for(int i = 0; i<10; i++) { if(i % 2
	 * != 0) { System.out.println(i +" ["+Thread.currentThread().getName()+"]"); } }
	 * }
	 */

}


