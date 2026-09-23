package com.threadsyncblock;



public class PrintThread implements Runnable
{
	
	Task task;
	 
	public PrintThread(Task task)
	{
		this.task = task;
	}

	public void run() {
		/* task.printEven(); */
		task.printOdd(); // check lock of task
	}
}