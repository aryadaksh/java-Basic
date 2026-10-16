package com.sampleJdbc.order;

import java.sql.SQLException;

public class Driver {

	public static void main(String[] args) {
		Order order = new Order();
		/*for(int i = 1000; i<1400; i++) {*/
		try {
			//order.updateOrder(i, "Hold");
			order.bulkCreateOrder();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//}
	}
}
