package com.digit.hibernateServlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.digit.hibernateServlet.model.UserModel;

@WebServlet("/loginUser")
public class LoginUser extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int userId = Integer.parseInt(req.getParameter("username"));
		String password = (String) req.getParameter("password");
		
		UserModel userModel = new UserModel();
		boolean isLogin = userModel.userLogin(userId, password);
		
		if(isLogin) {
	    	session.setAttribute("student_id", userId);
	    	res.sendRedirect("userMenu.html");
	    }else { 
			res.sendRedirect("failed.jsp");
	    }
	}
}
