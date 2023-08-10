package com.digit.hibernateServlet.bean;

public class BankAccountDetails {
	int acc_no;
	String pin;
	int amount;

	public BankAccountDetails(int acc_no, String pin, int amount) {
		super();
		this.acc_no = acc_no;
		this.pin = pin;
		this.amount = amount;
	}
}
