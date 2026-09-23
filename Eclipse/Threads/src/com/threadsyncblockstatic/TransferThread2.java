package com.threadsyncblockstatic;

public class TransferThread2 extends Thread {
    private BankAccount account;

	/*
	 * public TransferThread2(BankAccount account) { this.account = account; }
	 */

    @Override
    public void run() {
        BankAccount/*account*/.transfer(500, "Thread2");
    }
}
