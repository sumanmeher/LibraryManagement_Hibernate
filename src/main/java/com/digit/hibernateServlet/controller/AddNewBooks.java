package com.digit.hibernateServlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernateServlet.bean.BookDetails;
import com.digit.hibernateServlet.model.AdminModel;

@WebServlet("/addNewBooks")
public class AddNewBooks extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String b_name=req.getParameter("b_name");
        String author=req.getParameter("author");
        int cost=Integer.parseInt(req.getParameter("cost"));
        String category=req.getParameter("category");
        
        BookDetails bd = new BookDetails();
        
        bd.setB_name(b_name);
        bd.setAuthor(author);
        bd.setCost(cost);
        bd.setCategory(category);
        bd.setStatus("inactive");
        
        AdminModel am = new AdminModel();
        boolean isAdded = am.addNewBooks(bd);
		if (isAdded == true) {
			res.sendRedirect("success.jsp");
		} else {
			res.sendRedirect("failed.jsp");
		}
	}

}
