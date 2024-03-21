package com.yashu.project.expenses;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		DBConfiguration DB = new DBConfiguration();
		
		Connection con = DB.DBConfig();
		
		String sql = "insert into login (UserName, UserPassword, ConfirmPassword) values (?, ?, ?)";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			String username = req.getParameter("UserName");
			String password = req.getParameter("UserPassword");
			String confirmpassword = req.getParameter("ConfirmPassword");
			
			pst.setString(1, username);
			pst.setString(2, password);
			pst.setString(3, confirmpassword);
			int rows = pst.executeUpdate();
			
			if (rows>0) {
				System.out.println("Registration Successful.");
				resp.sendRedirect("User_Login.html");
			}
			else {
				System.out.println("Registration UnSuccessful.");
				resp.sendRedirect("User_Login.html");
			}
			
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	}
}
