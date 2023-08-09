package com.digit.hibernateServlet.model;

import java.io.Serializable;
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
import com.digit.hibernateServlet.bean.UserDetails;

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
		Transaction tran = session.beginTransaction();
		AdminDetails ad = (AdminDetails) session.get(AdminDetails.class, username);

		if (ad.getSecret_pass().equals(password)) {
			return true;
		}
		tran.commit();

		return false;
	}
	
	public List viewPurchaseHistory() {
		Transaction tran = session.beginTransaction();
		Query q = session.createQuery("From PurchaseHistoryDetails");
		List li = q.list();
		Iterator itr = li.iterator();

		tran.commit();
		return li;

	}
	public boolean register(UserDetails ud) {
		Transaction tran = session.beginTransaction();
		Serializable save = session.save(ud);
		tran.commit();
		System.out.println("Registered");
		if (save == null) {
			return false;
		}
		return true;
	}
	
	public boolean addNewBooks(BookDetails bd) {
		Transaction tran = session.beginTransaction();
		Serializable save = session.save(bd);
		tran.commit();
		System.out.println("Books Added");
		if (save == null) {
			return false;
		}
		return true;
	}

}
