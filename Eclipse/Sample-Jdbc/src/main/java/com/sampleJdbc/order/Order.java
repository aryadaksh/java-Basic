package com.sampleJdbc.order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Order {

	public void updateOrder(int _id,String _status) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/1st_June_2026", "daksh", "Daksh@7764");
		
		String quary = "UPDATE order_history SET status = ? WHERE id = ?"; 
		
		PreparedStatement preparedStatement = connection.prepareStatement(quary);
		preparedStatement.setString(1, _status);
		preparedStatement.setInt(2, _id);
		
		int update  = preparedStatement.executeUpdate();
		System.out.println("Update Value:"+update);
		
	}

	public void bulkCreateOrder() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/1st_June_2026", "daksh", "Daksh@7764");
		
		String quary = "INSERT INTO order_history (id, item, price, status) VALUES ( ?,  ?,?, ?  )";
		
		PreparedStatement preparedStatement = connection.prepareStatement(quary);
		int count = 0;
		int batchSize =500;
		for(int i = 2001; i<=5069; i++ ) {
			preparedStatement.setInt(1, i);
			preparedStatement.setString(2, "iphone" +i);
			preparedStatement.setInt(3, 500000);
			preparedStatement.setString(4, "HOLD");
			preparedStatement.addBatch();
			
			if(i % batchSize == 0) {
				preparedStatement.executeBatch();  // execute accumulated batch
		        count++;
		        System.out.println("Executed batch: " + count);
			}
			
			
		}
		
		preparedStatement.execute();


	}

}
