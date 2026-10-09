package com.comfuture1;

import java.util.concurrent.CompletableFuture;

public class DriverThenRun {
	public static void main(String[] args) {
		CompletableFuture.supplyAsync(() -> {
			System.out.println("Thread Name1: "+Thread.currentThread().getName());
			return 20;
		}).thenRun(() -> {
			System.out.println("Thread Name2: "+Thread.currentThread().getName());
			
		});
	}

}
