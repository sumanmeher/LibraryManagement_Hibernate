package com.digit.hibernateServlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.hibernateServlet.bean.AdminDetails;
import com.digit.hibernateServlet.model.AdminModel;

@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		try {
			int username = Integer.parseInt(req.getParameter("username"));
			String password = req.getParameter("password");

			AdminModel adminModel = new AdminModel();
			boolean isLogin = adminModel.login(username, password);

			if (isLogin) {
				session.setAttribute("student_username", username);
				session.setAttribute("s_marks", password);
				res.sendRedirect("adminMenu.jsp");
			} else {
				res.sendRedirect("failed.jsp");
			}
		} catch (Exception e) {
			res.sendRedirect("failed.jsp");
		}
	}
}
