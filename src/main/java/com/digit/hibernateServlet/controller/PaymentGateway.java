package com.digit.hibernateServlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.hibernateServlet.model.UserModel;

@WebServlet("/paymentGateway")
public class PaymentGateway extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		try {
		int acc_no = Integer.parseInt(req.getParameter("acc_no"));
		int pin = Integer.parseInt(req.getParameter("pin"));
		int amount = (int) session.getAttribute("subscription_amount");
		int userId=(int) session.getAttribute("student_id");
		
		UserModel um = new UserModel();
		boolean pg = um.paymentGateway(acc_no,pin, userId, amount);
		if(pg)
			res.sendRedirect("success.jsp");
		else
			res.sendRedirect("failed.jsp");
		}catch (Exception e) {
			res.sendRedirect("failed.jsp");
		}
	}
}
