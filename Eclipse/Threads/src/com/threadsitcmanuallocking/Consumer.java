package com.threadsitcmanuallocking;

public class Consumer extends Thread
{
	
Task task ;
	
	public Consumer(Task _task) {
		this.task = _task;
	}
	
	@Override
	public void run() {
		for(int i = 0; i<5; i++) {
		try {
			task.consumer();;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	

}
