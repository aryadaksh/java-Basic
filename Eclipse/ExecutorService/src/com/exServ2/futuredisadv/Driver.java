package com.exServ2.futuredisadv;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Task implements Callable<Boolean> {
	EmailSender emailSender;

	public Task(EmailSender _emailSender) {
		this.emailSender = _emailSender;
	}

	@Override
	public Boolean call()  {
		System.out.println("Exceuting");
		return emailSender.sendEmail();

	}

}

public class Driver {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("Driver.main() -START");

		/* ExecutorService execService = Executors.newFixedThreadPool(5); */
		ExecutorService execService = Executors.newCachedThreadPool();
		for (int i = 0; i < 200; i++) {
			Future<Boolean> futureResponse = execService
					.submit(new Task(new EmailSender("daksh@hello.com__" , "this is body__" )));

			//Basically .get() does ki this stop the thread from which its called like here main() thread will wait
			//System.out.println(futureResponse.get());

		}

		System.out.println("Driver.main() -START");
		execService.shutdown();
	}

}
