package com.digit.hibernateServlet.model;

import java.io.Serializable;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import com.digit.hibernateServlet.bean.BankAccountDetails;
import com.digit.hibernateServlet.bean.BookDetails;
import com.digit.hibernateServlet.bean.PurchaseHistoryDetails;
import com.digit.hibernateServlet.bean.SubscriptionDetails;
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
		
		
		Serializable save = session.save(ps);
		tran.commit();
		return true; 
	}

	public void subscription(int acc_no, int amount) {
//		BankAccountDetails bank = (BankAccountDetails)session.get(BankAccountDetails.class, acc_no); 
		
	}

	public void paymentGateway(int acc_no, int pin, int userId, int amount) {
		Transaction tran = session.beginTransaction();
		BankAccountDetails bank = (BankAccountDetails)session.get(BankAccountDetails.class, acc_no); 
		if(bank.getPin()==pin){
			if(bank.getAmount()>=amount) {
				bank.setAmount(bank.getAmount()-amount);
				session.update(bank);
				
				 Random rand = new Random();
				 int rand_int1 = rand.nextInt(1000);
				
				 
//				 LocalDate now = java.time.LocalDate.now();
				 
				 Date dat = new Date();
				 SimpleDateFormat format = new SimpleDateFormat("dd/mm/yy");
				 String date = format.format(dat);
				 
				 
				 SubscriptionDetails sub = new SubscriptionDetails();
				sub.setU_id(userId);
				sub.setAmount(amount);
				sub.setInvoice_no(rand_int1);
				sub.setDate(date);
				session.save(sub);
				
				tran.commit();
			}
		}
	}
	
	
	
	
}
