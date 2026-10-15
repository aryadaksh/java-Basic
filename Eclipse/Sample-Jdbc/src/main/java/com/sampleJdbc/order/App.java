package com.sampleJdbc.order;

import java.sql.SQLException;

/*
 * CREATE
 * Read
 * Update 
 * Delete
 * 
 */

public class App 


{
	
    public static void main( String[] args )
    {
    	
    	
        OrderMgmt orderMgmt = new OrderMgmt();
        
        
       
        
        try {
        	orderMgmt.deleteData("104");
        	
        	//orderMgmt.updateDetails("5", "Shipped");
        	
        	// orderMgmt.addDetails("104", "Keyboard", "1500", "Cancelled");
		//	orderMgmt.getAllDetails("5");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
