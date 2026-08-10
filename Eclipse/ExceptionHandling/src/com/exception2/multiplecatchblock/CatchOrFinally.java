package com.exception2.multiplecatchblock;

public class CatchOrFinally {
	
	int whichOne() {
		int number = 0;
		try {
			 number = 1;
		int value = 5/0;
		}
		catch(ArithmeticException e) {
			number = 5;
		}
		
		finally {
			number = 10;
		}
		return number;
	}
	
	public static void main(String[] args) {
		
		CatchOrFinally cof = new CatchOrFinally();
		int result = cof.whichOne();
		System.out.println(result);
	}

}
