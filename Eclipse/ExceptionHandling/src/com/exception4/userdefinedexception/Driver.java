package com.exception4.userdefinedexception;

public class Driver {

	public static void main(String[] args) {
		Registration registration = new Registration();
		
		try  {
		registration.doRegistration("Dawik123");
		}
		catch(UserIdAlreadyPresentException exceptionObject) {
			System.out.println(exceptionObject.getMessage());
		}
	}
}
