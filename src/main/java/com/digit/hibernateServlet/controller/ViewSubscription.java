package com.digit.hibernateServlet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.hibernateServlet.model.AdminModel;

@WebServlet("/ViewSubscription")
public class ViewSubscription extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		AdminModel am = new AdminModel();
		HttpSession session = req.getSession();
		List viewSubscription = am.viewSubscription();
		session.setAttribute("viewSubscription", viewSubscription);
		if (viewSubscription == null) {
			res.sendRedirect("failedAdminMenu.jsp");
		} else {
			res.sendRedirect("viewSubscription.jsp");
		}

	}

}
