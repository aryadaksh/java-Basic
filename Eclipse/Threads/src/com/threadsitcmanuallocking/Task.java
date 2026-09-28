package com.threadsitcmanuallocking;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Task {

	ReentrantLock lock = new ReentrantLock();
	Condition condition =  lock.newCondition();

	int data;
	boolean isDataAvaiable = false;

	public void produce(int _data) throws InterruptedException {

		lock.lock();

		while (isDataAvaiable) {
			condition.await();
		}

		this.data = _data;
		System.out.println("Producing the data " + data);
		isDataAvaiable = true;
		 condition.signal();

		lock.unlock();
	}

	public void consumer() throws InterruptedException {
		lock.lock();
		while (!isDataAvaiable) {
			condition.await();
		}

		System.out.println("Producing the data " + data);
		isDataAvaiable = false;
		condition.signal();
		
		
		lock.unlock();
		
	}
}
