package com.threadusing1;

public class Task {
	
	public void printEven() {
		for(int i = 0; i<10; i++) {
			if(i % 2== 0) {
				System.out.println(i +" "+Thread.currentThread().getName());
			}
		}
	}
	
	public void printOdd() {
		for(int i = 0; i<10; i++) {
			if(i % 2!= 0) {
				System.out.println(i +" "+Thread.currentThread().getName());
			}
		}
	}

}
