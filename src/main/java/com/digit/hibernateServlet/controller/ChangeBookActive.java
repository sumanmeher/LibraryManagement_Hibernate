package com.digit.hibernateServlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernateServlet.model.AdminModel;

@WebServlet("/changeBookActive") 
public class ChangeBookActive extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int bookId= Integer.parseInt(req.getParameter("bookId"));
		AdminModel adminModel = new AdminModel();
		boolean done = adminModel.changeBookActive(bookId);
	    if(done) {
	    	res.sendRedirect("success.jsp");
	    }else {
	    	res.sendRedirect("failed.jsp");  
	    }
	}
}
