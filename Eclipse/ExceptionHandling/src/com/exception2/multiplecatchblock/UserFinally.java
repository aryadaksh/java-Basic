package com.exception2.multiplecatchblock;

public class UserFinally {

	void multipleCatch(String name, String password) {

		try {

			int pass = Integer.parseInt(password);

			String userId = name.substring(0, 3) + "777";

			char v = name.charAt(0);

			System.out.println("User Id:" + userId + " Pass" + pass);
		}

		catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("Please provide a valid name");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("Its a string value its won't convert into integer");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unknown error");
		}
		finally {
			System.out.println("Close the all connection and close the all object created");
		}
	}

}
