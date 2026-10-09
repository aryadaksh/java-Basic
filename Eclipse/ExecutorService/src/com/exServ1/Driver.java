package com.exServ1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Basically ExecutorService its won't terminate the thread after excution we can use same thread multiple time 

class MyThread extends Thread
{
	int taskId;
	
	public MyThread(int _taskId) {
		this.taskId = _taskId;
	}
	
	@Override
	public void run() {
		
		System.out.println("MyThread.run()... Task Id : "+taskId+" ["+Thread.currentThread().getName()+"]");
		
	}
	
}

public class Driver {
	
	public static void main(String[] args) {
		
		//we are going to use executor Service
		
		ExecutorService executorService =  Executors.newFixedThreadPool(2);
		
		// Excuting task 
		for(int i = 0; i<10; i++) {
		
		executorService.execute(new MyThread(i));
		}
		
		// ExecutorService wont terminate 
		executorService.shutdown();
	}

}
