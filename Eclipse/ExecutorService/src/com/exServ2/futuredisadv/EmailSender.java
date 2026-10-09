package com.exServ2.futuredisadv;

public class EmailSender {
	
	String email;
	String body;
	public EmailSender(String _email, String _body) {
		
		this.email = _email;
		this.body = _body;
	}
	
	public boolean sendEmail() {
		System.out.println("Sending email to "+email+"\n"+body+" ["+Thread.currentThread().getName()+"]");
		/*
		 * try { Thread.currentThread().sleep(1000); } catch (InterruptedException e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		return true;
	}
	

}
