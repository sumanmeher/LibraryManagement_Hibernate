package com.digit.hibernateServlet.model;

import java.sql.Connection;

public class AdminModel {
	public static Connection con;
	
	String admin_id;
	String secret_pass;
	
	
	public String getAdmin_id() {
		return admin_id;
	}


	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}


	public String getSecret_pass() {
		return secret_pass;
	}


	public void setSecret_pass(String secret_pass) {
		this.secret_pass = secret_pass;
	}


	public AdminModel() {
		DatabaseModel db = new DatabaseModel();
		con=DatabaseModel.con;
	}
}
