package com.model;

public class Address {
	
	private String line1;
	private String line2;
	
	public Address(String _line1, String _line2) {
		this.line1= _line1;
		this.line2 = _line2;
	}
	
	public String getAddress() {
		return line1+" "+line2;
	}

}
