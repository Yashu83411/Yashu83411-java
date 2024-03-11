package com.yashu.project.expenses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfiguration {
	public Connection DBConfig() {
		Connection con = null;
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver Connected Successfully.");
				
				String url = "jdbc:mysql://localhost:3306/myexpenses";
				String uname = "root";
				String pass = "Dhayash@2034";
				
				con = DriverManager.getConnection(url, uname, pass);
				System.out.println("Db connected successfully.");
				
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					System.out.println("Driver not Connected."+ e.getMessage());
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("Db not connected.");
				}
			return con;
	}
}
