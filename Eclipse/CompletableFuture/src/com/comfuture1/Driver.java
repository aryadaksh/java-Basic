package com.comfuture1;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class Driver {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		/*
		 * CompletableFuture<Integer> completableFuture =
		 * CompletableFuture.supplyAsync(() -> {
		 * System.out.println(Thread.currentThread().getName()); return 20; });
		 */
		
		System.out.println("Driver.main() ");
		
		// supplyAsync basically does its return something but its not except any input
		CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
			System.out.println(Thread.currentThread().getName());
			return 20;
		},Executors.newFixedThreadPool(2));
		
		System.out.println(completableFuture.get());
	}
	
}
