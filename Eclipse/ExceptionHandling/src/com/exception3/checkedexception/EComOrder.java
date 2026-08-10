package com.exception3.checkedexception;

public class EComOrder {

	void placeOrder(String itemName, int qty) throws NullPointerException //,Exception
	{
			
		
		System.out.println("Item name::"+itemName);
		
		if(itemName == null || qty<0) {
			throw new NullPointerException("Quanity should be greater Than or equal to one  zero  or \nPlease Privide valid Item Name");
			
		}
		
		//else 
		System.out.println("Quanity of Item :"+qty);
	}
	
	public static void main(String[] args)
	{
		EComOrder ecom = new EComOrder();
		try {
			ecom.placeOrder(null, 1);
		} catch (NullPointerException e) {
			
			System.out.println(e.getMessage());
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
		}
	}
}

