package com.digit.hibernateServlet.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseModel {
	public static Connection con;
	public DatabaseModel() {
		String url = "jdbc:mysql://localhost:3306/library_management";
		String user = "root";
		String pwd = "Dhoni$1234";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
