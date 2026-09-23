package com.threadsyncblockstatic;

public class BankAccount {
    private static double balance = 1000;

	/*
	 * public BankAccount(double balance) { this.balance = balance; }
	 */

    // synchronized block inside method
	public /* synchronized */ static void transfer(double amount, String threadName) /* throws InterruptedException */ {
        /*synchronized (this) {*/
		
		synchronized (BankAccount.class) {
			
		
            if (balance >= amount) {
            	try {
					Thread.sleep(20000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                System.out.println(threadName + " is transferring: " + amount);
                balance -= amount;
                System.out.println(threadName + " completed transfer. Remaining balance: " + balance);
            } else {
                System.out.println(threadName + " tried to transfer but insufficient funds!");
            }
			/* } */
		}
    }
}
