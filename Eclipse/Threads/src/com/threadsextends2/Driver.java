package com.threadsextends2;

class EmailSender extends Thread{
	
	public void run() {
		//WHen thread us in RUNNING state -->
		// THread is doing work/Task
		//From RUNNING to WAITING/BLOCKED 
		//once waiting ended again RUNNABLE 
		// once CPU allows ,Thread moved to RUNNING state 
		// once run method is completed by thread , the is moves to TERMINATED(DEAF) state
		
		
		System.out.println(" Sending email..."+Thread.currentThread().getName());
	}
}

public class Driver {
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		
		// once THread object is created , State -> New
		EmailSender t1  = new EmailSender();
		
		// state = Runnable
		t1.start(); // New --> RUNNABLE
	//	t1.start(); // Terminated --> X // its will give EXCPTION IllegalThreadStateException
		// once CPU gives time to execute/run then state will be RUNNING
	}

}
