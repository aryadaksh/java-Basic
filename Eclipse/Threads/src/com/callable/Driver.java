package com.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Before java 1.5 we used to do update on db that this task is completed and in main thread 
//they used to check by reading the db is the task is completed or not

class AddNumber implements Callable<Boolean> {

	int num1, num2;

	public AddNumber(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}

	@Override
	public Boolean call() throws Exception {

		int sum = num1 + num2;

		if (sum > num1 && sum > num2) {
			return true;
		} else
			return false;

	}
}

public class Driver {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		AddNumber addNumber = new AddNumber(3, 5);
		ExecutorService excService = Executors.newFixedThreadPool(1);
		try {
			Future<Boolean> futureResponse = excService.submit(addNumber);

			System.out.println("Is Two number is added: " + futureResponse.get());
		} finally {
			excService.shutdown();
		}

	}
}
