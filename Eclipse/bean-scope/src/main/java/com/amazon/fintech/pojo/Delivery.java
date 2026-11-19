package com.amazon.fintech.pojo;



public class Delivery {
	
	private String status;
	private String deliveryId;
	private String customerId;
	public Delivery(String status, String deliveryId, String customerId) {
		super();
		this.status = status;
		this.deliveryId = deliveryId;
		this.customerId = customerId;
	}
	
	
	public String display() {
		return "Delivery [status=" + status + ", deliveryId=" + deliveryId + ", customerId=" + customerId + "]";
	}
	
	

}
