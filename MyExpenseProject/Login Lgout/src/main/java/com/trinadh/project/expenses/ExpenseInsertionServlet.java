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

@WebServlet("/ExpenseInsertionServlet")
public class ExpenseInsertionServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		DBConfiguration DB = new DBConfiguration();
		
		Connection con = DB.DBConfig();
		
		String sql = "insert into expenses (ExpenseDate, ExpenseCategory, ExpenseDetails, ExpenseAmount) values (?, ?, ?, ?)";
			
			//String userid = (String)req.getSession().getAttribute("userid");
			String expdate = req.getParameter("ExpenseDate");
			String expcat = req.getParameter("ExpenseCategory");
			String expdetails = req.getParameter("ExpenseDetails");
			String expamount = req.getParameter("ExpenseAmount");
			

			try {
				PreparedStatement pst = con.prepareStatement(sql);
				
				pst.setString(1, expdate);
				pst.setString(2, expcat);
				pst.setString(3, expdetails);
				pst.setString(4, expamount);
				int rows = pst.executeUpdate();
				
				if (rows>0) {
					System.out.println("Expense Insertion Successful.");
					resp.sendRedirect("FetchUserExpenseServlet");
				}
				else {
					System.out.println("Expense Insertion UnSuccessful.");
					resp.sendRedirect("Homepage.html");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
	}
}
