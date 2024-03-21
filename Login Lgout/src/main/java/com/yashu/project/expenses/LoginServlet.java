package com.yashu.project.expenses;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		DBConfiguration DB = new DBConfiguration();
		
		Connection con = DB.DBConfig();
		
		String sql = "select * from login where UserName=? and UserPassword=?";
			
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			String username = req.getParameter("UserName");
			String password = req.getParameter("UserPassword");
			
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			
			PrintWriter out = resp.getWriter();
			
			if (rs.next()) {
				int userid = rs.getInt("UserId");
				ServletContext sContext = getServletContext();
				sContext.setAttribute("userid", userid);
				sContext.setAttribute("username", username);
				
				HttpSession session = req.getSession();
				session.setAttribute("userid", userid);
				session.setAttribute("username", username);
				resp.sendRedirect("Homepage.html");
			}
			else {
				out.print("Sorry, username or password error!"); 
				resp.sendRedirect("User_Login.html");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
