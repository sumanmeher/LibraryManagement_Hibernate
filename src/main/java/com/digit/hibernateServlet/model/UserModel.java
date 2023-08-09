package com.digit.hibernateServlet.model;

import java.sql.Connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import com.digit.hibernateServlet.bean.UserDetails;

public class UserModel {
	public static Connection con;
	public static Session session;

	public UserModel() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml"); // connects to cfg
		ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.buildServiceRegistry());

		session = sessionFactory.openSession();
		System.out.println("Connected to pf...");
	}
	
	public boolean userLogin(int userId, String password) {
		Transaction tran = session.beginTransaction();
		UserDetails ad = (UserDetails) session.get(UserDetails.class, userId);

		if (ad.getPass().equals(password) && ad.getStatus().equals("active")) {
			return true;
		}
		tran.commit();

		return false;
		
	}
	
	
	
	
}
