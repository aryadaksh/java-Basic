package com.threadsitc;

public class Task {

	int data;
	boolean isDataAviable = false;

	public synchronized void produce(int _data) throws InterruptedException {

		while (isDataAviable) {
			/*
			 * System.out.println("["+Thread.currentThread().getName()+"] is waiting...");
			 */			wait();
		}

		this.data = _data;
		System.out.println("Procucing the data: " + data);
		isDataAviable = true;
		notify();
	}

	public synchronized void consume() throws InterruptedException {

		while (!isDataAviable) {
			/*
			 * System.out.println("["+Thread.currentThread().getName()+"] is waiting...");
			 */			wait();
		}

		
		System.out.println("Consuming the data: " + data);
		isDataAviable = false;
		notify();
	}

}
