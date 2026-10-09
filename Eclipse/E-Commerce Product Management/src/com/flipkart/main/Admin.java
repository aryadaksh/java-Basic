package com.flipkart.main;

public class Admin {
	
	{

		System.out.println("========================================");
		System.out.println("       ====-- Admin Layout --====");
		System.out.println("========================================");

	}

	private int adminId;
	private String name;
	private String email;
	private String password;

	public Admin(int adminId, String name, String email, String password) {
		this.adminId = adminId;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	// Getters
	public int getAdminId() {
		return adminId;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "Admin #" + adminId + " - " + name + " (" + email + ")";
	}

}
