package com.pojoclass;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + "]";
	}
	private String name;
	private String id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	

}
