package com.sampleJdbc.order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * CREATE
 * Read
 * Update 
 * Delete
 * 
 */

public class OrderMgmt {

	/*
	 * Create
	 */

	public void addDetails(String _id, String _item, String _price, String _status)
			throws ClassNotFoundException, SQLException {
		// Dynamic class loading
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Doing Connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/1st_June_2026", "daksh",
				"Daksh@7764");

		// Create Statement
		Statement statement = connection.createStatement();

		String query = "INSERT INTO order_history (id, item, price, status) VALUES (" + _id + ", '" + _item + "' ,"
				+ _price + ", '" + _status + "' )";

		System.out.println(query);

		int resultSet = statement.executeUpdate(query);
		System.out.println("Updated in qeuery ==>" + resultSet);

	}

	/*
	 * Read -> using id
	 */

	public void getAllDetails(String _id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/1st_June_2026", "daksh",
				"Daksh@7764");

		Statement statement = connection.createStatement();

		// Query

		String query = null;
		if (_id != null) {
			query = "Select * From order_history Where id = " + _id;
		} else {
			query = "Select * From order_history";
		}

		ResultSet resultSet = statement.executeQuery(query);

		while (resultSet.next()) {
			System.out.println("Id::" + resultSet.getInt(1));
			System.out.println("Item::" + resultSet.getString(2));
			System.out.println("Price::" + resultSet.getInt(3));
			System.out.println("Status::" + resultSet.getString(4));
			System.out.println("=======================================");
		}

	}
	

	/*
	 * Update
	 */

	public void updateDetails(String _id, String _status) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Connection 
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/1st_June_2026","daksh","Daksh@7764");
		
		//Statement
		Statement statement = connection.createStatement();
		
		//Querey 
		String query = "UPDATE order_history SET status = '" + _status + "' WHERE id = " + _id;
		
		System.out.println(query);
		
		int resultSet = statement.executeUpdate(query);
		System.out.println("Updated : "+resultSet);
		
	}
	
	/*
	 * Delete row
	 */
	public void deleteData(String _id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Connection 
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/1st_June_2026", "daksh","Daksh@7764");
		
		//statement 
		Statement statement = connection.createStatement();
		
		String query = "DELETE FROM order_history WHERE id = " + _id;

		System.out.println(query);

		int resultSet = statement.executeUpdate(query);
		System.out.println("Exceuted====>"+resultSet);
	}

}
