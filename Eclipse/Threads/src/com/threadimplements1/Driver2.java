package com.threadimplements1;

class PrintNum implements Runnable
{
	// run methods doesn't throw excpetion

	@Override
	public void run() {
		
		for(int i = 0; i<10; i++) {
			if(i == 5) // some biz condition
			{
				System.out.println(" Sleeping...");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(" Sleeping is Over.. i just woke up... started work again");
			}
			
			System.out.println("  Printing : "+i+" "+Thread.currentThread().getName());
		}
		
	}
	
}

public class Driver2 {
	
	public static void main(String[] args) {
		
		System.out.println("Start "+Thread.currentThread().getName());
		
		PrintNum numPrint = new PrintNum();
		
		Thread t1 = new Thread(numPrint);
		t1.setName("PrintingNumber Thread");
		t1.start();
		
		System.out.println("Ended "+Thread.currentThread().getName());
	}

}
