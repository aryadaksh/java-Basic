package com.exception2.multiplecatchblock;

public class Driver {
	
	public static void main(String[] args) {
//		User user = new User();
//		user.multipleCatch(null, "123");
		
		UserFinally uf = new UserFinally();
		uf.multipleCatch("Rajrahul", "234");
	}

}
