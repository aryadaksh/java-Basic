package com.threadsextends2;

class Numbers extends Thread {

	public void run() {
		
		
		
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " Thread Name::" + Thread.currentThread().getName() + " Thread Id::"
					+ Thread.currentThread().getId() /* + " " + " Thread Id::" + Thread.currentThread().threadId() */);
		}

	}

	
	  public long getId() { return 21; }
	 

}

public class PrintNumUsingThread {

	public static void main(String[] args) {
		System.out.println("Main Started " + " Thread Name::" + Thread.currentThread().getName() + " Thread Id::"
				+ Thread.currentThread().getId());

		Numbers t1 = new Numbers();
		t1.setName("T1");
		t1.start();

		Numbers t2 = new Numbers();
		t2.setName("T2");
		t2.start();
	}

}
