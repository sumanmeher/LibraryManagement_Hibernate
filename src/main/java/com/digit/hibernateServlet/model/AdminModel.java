package com.digit.hibernateServlet.model;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AdminModel {
	public static Connection con;
	public static Session session;
	
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
	
	public List viewSubscription() {
		Transaction tran = session.beginTransaction();
		Query q = session.createQuery("From SubscriptionDetails");
		List li = q.list();
		Iterator itr = li.iterator();
	
		tran.commit();
		return li;
		
	}
}
