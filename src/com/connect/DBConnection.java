package com.connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/batch1043", "root", "Payal@123");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
