package com.digit.hibernateServlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernateServlet.bean.UserDetails;
import com.digit.hibernateServlet.model.AdminModel;

@WebServlet("/Register")
public class Register extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String u_name = req.getParameter("u_name");
		String pass = req.getParameter("pass");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		
		if(pass.length()<8 || phone.length()!=10) {
			res.sendRedirect("failed.jsp");
			return; 
		}

		UserDetails ud = new UserDetails();

		ud.setU_name(u_name);
		ud.setPass(pass);
		ud.setAddress(address);
		ud.setPhone(phone);
		ud.setEmail(email);
		ud.setStatus("inactive");

		AdminModel am = new AdminModel();
		boolean isRegistered = am.register(ud);
		if (isRegistered == true) {
			res.sendRedirect("success.jsp");
		} else {
			res.sendRedirect("failed.jsp");
		}

	}

}
