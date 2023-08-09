package com.digit.hibernateServlet.model;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import com.digit.hibernateServlet.bean.AdminDetails;
import com.digit.hibernateServlet.bean.BookDetails;

public class AdminModel {

	public static Connection con;
	public static Session session;
	
	public AdminModel() {
		DatabaseModel db = new DatabaseModel();
		con=DatabaseModel.con;
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml"); // connects to cfg
		ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.buildServiceRegistry());

		session = sessionFactory.openSession();
		System.out.println("Connected to pf...");
	}
	
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



	
	public List viewSubscription() {
		Transaction tran = session.beginTransaction();
		Query q = session.createQuery("From SubscriptionDetails");
		List li = q.list();
		Iterator itr = li.iterator();
	
		tran.commit();
		return li;
		
	}
	
	public boolean login(int username, String password) {

		
		Transaction tran=session.beginTransaction();
		AdminDetails ad = (AdminDetails) session.get(AdminDetails.class,username);
    	
		if(ad.getSecret_pass().equals(password)) {
			return true;
		}
		tran.commit();
    	
		return false;
	}
	
	public List inactiveBoooks() {
		Transaction tran=session.beginTransaction();
//		BookDetails ad = (BookDetails) session.get(BookDetails.class,username);
		Query q = session.createQuery("From BookDetails where status='inactive'");
		List li = q.list();
		return li;
		
	}
	
}
