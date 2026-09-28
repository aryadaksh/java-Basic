package com.threadsitcusinflammda;

public class Driver {
	
	public static void main(String[] args) {
		
		Task task = new Task();
		
		Thread producer = new Thread(() ->{
			for(int i = 0; i<5; i++) {
			try {
				task.produce(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		});
		
		Thread consumer = new Thread(() ->{
			for(int i = 0; i<5; i++) {
			try {
				task.consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		});
		
		
		producer.setName("Producer");
		consumer.setName("Consumer");
		
		producer.start();
		consumer.start();
		
		
	}

}
