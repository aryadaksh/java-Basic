package com.threadsextends1;

//There are two ways to create create Thread by extending Thread class or Runnable interface
//The process to create new Thread using Thread class
//1.Create Class extends to Thread
//2. in that class we need to override / implements run method in that we write logic its return type is void
//3 . we will create object of that class and we call object name.start()
// 4 . will excute the custom thread randomly 

class MyThread extends Thread
{
	@Override
	public void run() {
		System.out.println("MyThread.run()");
		System.out.println("MyThread: this code is excuted by ["+Thread.currentThread().getName()+"] thread");
	}
	
}

public class Driver {
	
	
	
	public static void main(String[] args) {
		
		System.out.println("main() Started");
		
		System.out.println("MyThread: this code is excuted by ["+Thread.currentThread().getName()+"] thread");
		
		MyThread t1 = new MyThread();
		t1.setName("t1");
		t1.start();
		
		MyThread t2 = new MyThread();
		t2.setName("t2");
		t2.start();
		
		MyThread t3 = new MyThread();
		t3.setName("t3");
		t3.start();
		
		MyThread t4 = new MyThread();
		t4.setName("t4");
		t4.start();
		
		System.out.println("main() Ended");
		
	}

}
