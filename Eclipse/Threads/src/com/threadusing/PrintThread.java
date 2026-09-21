package com.threadusing;

public class PrintThread extends Thread
{
	Task task;
	
	public PrintThread(Task _task) {
		this.task = _task;
	}
	
	@Override
	public synchronized void run() {
		task.printNumbers();
	}

}
