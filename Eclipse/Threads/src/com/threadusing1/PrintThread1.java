package com.threadusing1;

public class PrintThread1 extends Thread
{
	Task task;

	public PrintThread1(Task task) {
		this.task = task;
	}
	
	public /* synchronized */ void run()
	{
		task.printEven();
		
	}
}

