package com.digit.hibernateServlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernateServlet.model.UserModel;

@WebServlet("/subscription")
public class Subscription extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String subscriptionType = req.getParameter("subscriptionType");
		int rate=0;
		switch(subscriptionType) {
		case "silver":
			rate=299;
			break;
		case "gold":
			rate=999;
			break;
		case "diamond":
			rate=1599;
			break;
		}
		
		UserModel um = new UserModel();
		
	}
}
