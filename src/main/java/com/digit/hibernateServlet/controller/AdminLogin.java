package com.digit.hibernateServlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.hibernateServlet.model.AdminModel;

@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String username= req.getParameter("username");
	    String password= req.getParameter("password");
	    AdminModel admin = new AdminModel();
//	    admin.setUsername(username);
//	    admin.setPassword(password);
//	    boolean isLogin = student.login(); 
//	    if(isLogin) {
//	    	session.setAttribute("loginType", "student");
//	    	session.setAttribute("student_username", student.getUsername());
//	    	session.setAttribute("s_marks", student.getGrade());
//	    	res.sendRedirect("studentMenu.jsp");
//	    }else { 
//	    	session.setAttribute("failed_name", "Student Login Failed");
//			session.setAttribute("failed_message", "Username and Password does not match");
//			res.sendRedirect("failed.jsp");
//	    }
	}
}
