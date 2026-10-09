package com.comfuture1;

import java.util.concurrent.CompletableFuture;
/*
 * If we use cmf1 one asyn and cmf2 one async and then combine one asyn the maximum number of worker thread will be 3 its internally 
 * use ForkJoinPool
 */

public class DriverThenCombine {
	public static void main(String[] args) /* throws InterruptedException, ExecutionException */ {
		
		
		
		// cmF1
		CompletableFuture<Integer> cmf1 = CompletableFuture.supplyAsync(() -> {
			System.out.println("Thread Name: " + Thread.currentThread().getName());
			return 7;
		}).thenApplyAsync((n) -> {
			System.out.println("Thread Name: " + Thread.currentThread().getName());
			return n * 49;
		});

		// cmf2
		CompletableFuture<Integer> cmf2 = CompletableFuture.supplyAsync(() -> {
			System.out.println("Thread Name: " + Thread.currentThread().getName());
			return 5;
		}).thenApplyAsync((n) -> {
			System.out.println("Thread Name: " + Thread.currentThread().getName());
			return n * 25;
		});

		// ThenCombine
		CompletableFuture<Integer> finalCMF = cmf2./* thenCombineAsync */thenCombine(cmf1, (a, b) -> {
			System.out.println("Thread Name: " + Thread.currentThread().getName());
			return a + b;

		});

		// Get basically throws exception throws InterruptedException,
		// ExecutionException
		/* System.out.println(finalCMF.get()); */ 

		// join doesn't throw exception
		System.out.println(finalCMF.join());

	}

}
