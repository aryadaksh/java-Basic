package com.comfuture1;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class DriverThenApply {
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
			System.out.println("Current Thread: " + Thread.currentThread().getName());
			return 20;
			// thenApply will not create a new Thread its will use current thread can be any 
		}).thenApply((n) -> {
			System.out.println("Current Thread: " + Thread.currentThread().getName());
			return n * 5;
			// thenApplyAsync will can create a new Thread its needed or else use same 
		}).thenApplyAsync((n) -> {
			System.out.println("Current Thread: " + Thread.currentThread().getName());
			return "Result ::" + n * 2;
		});

		System.out.println(completableFuture.get());
	}

}
