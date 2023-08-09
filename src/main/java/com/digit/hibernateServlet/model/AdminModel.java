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

public class AdminModel {

	public static Connection con;
	public static Session session;
	
	public AdminModel() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml"); // connects to cfg
		ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.buildServiceRegistry());

		session = sessionFactory.openSession();
		System.out.println("Connected to pf...");
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
	
}
