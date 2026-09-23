package com.threadsyncblockstatic;

public class TransferThread1 extends Thread {
    private BankAccount account;

	/*
	 * public TransferThread1(int i) { this.account = i; }
	 */

    @Override
    public void run() {
        BankAccount/*account*/.transfer(800, "Thread1");
    }
}
