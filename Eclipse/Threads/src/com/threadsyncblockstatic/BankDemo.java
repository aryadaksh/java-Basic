package com.threadsyncblockstatic;

public class BankDemo {
    public static void main(String[] args) {
		/* BankAccount account = new BankAccount(1000); */

		TransferThread1 t1 = new TransferThread1(/* account */);
		TransferThread2 t2 = new TransferThread2(/* account */);

        t1.start();
        t2.start();
    }
}
