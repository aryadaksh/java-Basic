package com.exception4.userdefinedexception;

public class Registration {
	
	public boolean doRegistration(String userId) throws UserIdAlreadyPresentException
	{
		boolean status = false;
		boolean isAvaible = true;
		
		if(!isAvaible) {
			status = true;
			System.out.println("UserIs is Registration doing...."+userId);
		}
		else {
			status = false;
			System.out.println("User Id is already Present : "+userId);
			throw new UserIdAlreadyPresentException("User Id is already Present : "+userId);
		}
		
		
		
		
		return status;
	}

}
