package com.digit.hibernateServlet.model;

import java.sql.Connection;

public class AdminModel {
	public static Connection con;
	public AdminModel() {
		DatabaseModel db = new DatabaseModel();
		con=DatabaseModel.con;
	}
}
