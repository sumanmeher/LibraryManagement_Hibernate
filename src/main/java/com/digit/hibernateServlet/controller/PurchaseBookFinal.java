package com.digit.hibernateServlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.hibernateServlet.model.UserModel;

@WebServlet("/PurchaseBookFinal")
public class PurchaseBookFinal extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int userId=1;
		int b_id = Integer.parseInt(req.getParameter("b_id"));
		//String b_name = (String) session.getAttribute("b_name");
		
		UserModel um = new UserModel();
		boolean isPurchase = um.purchaseBook(b_id, userId);
		if(isPurchase==true) {
			res.sendRedirect("success.jsp");
		} else {
			res.sendRedirect("failed.jsp");
			
		}
	}
}
