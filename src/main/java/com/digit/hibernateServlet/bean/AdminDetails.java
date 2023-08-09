package com.digit.hibernateServlet.bean;

public class AdminDetails {
	int admin_id;
	String secret_pass;
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getSecret_pass() {
		return secret_pass;
	}
	public void setSecret_pass(String secret_pass) {
		this.secret_pass = secret_pass;
	}

}
