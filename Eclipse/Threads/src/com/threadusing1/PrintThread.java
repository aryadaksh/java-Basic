package com.threadusing1;

public class PrintThread extends Thread
{
	Task task;

	public PrintThread(Task task) {
		this.task = task;
	}
	
	public  synchronized  void run()
	{
		task.printEven();
		
	}
}
