package com.digit.hibernateServlet.model;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import com.digit.hibernateServlet.bean.BookDetails;
import com.digit.hibernateServlet.bean.PurchaseHistoryDetails;
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
//		tran.commit();
		
		
//		PurchaseHistoryDetails ps1=new PurchaseHistoryDetails(5,5,"asdf",1,123,123);
//		session.saveOrUpdate(ps1);

		tran.commit();
		return false;
		
	}
	
	public boolean purchaseBook(int bookId, int userId) {
		Transaction tran = session.beginTransaction();
		
		int invoice_no = new Random().nextInt(900000) + 100000;
		
		BookDetails book = (BookDetails) session.get(BookDetails.class, bookId);
		
		PurchaseHistoryDetails ps = new PurchaseHistoryDetails();
		ps.setB_id(bookId);
		ps.setB_name(book.getB_name());
		ps.setU_id(userId);
		ps.setAmount(book.getCost());
		ps.setInvoice_no(invoice_no);
		
		
//		System.out.println(bookId+ps.getB_id()+ps.getB_name());
//		PurchaseHistoryDetails ps1=new PurchaseHistoryDetails(5,5,"asdf",1,123,123);
		Serializable save = session.save(ps);
		tran.commit();
		return true;
	}
	
	
	
	
}
