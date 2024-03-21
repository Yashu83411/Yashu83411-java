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

@WebServlet("/FetchUserExpenseServlet")
public class FetchUserExpenseServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw = resp.getWriter();
		ServletContext sContext = getServletContext();
		String sessionUserName = sContext.getAttribute("username").toString();
		System.out.println(sContext.getAttribute("username"));
		
		pw.print("<div>\r\n"
				+ "			<form action=\"ExpenseInsertionServlet\" method=\"\" >\r\n"
				+ "				<table>\r\n"
				+ "					<tr>\r\n"
				+ "						<td><input type='hidden' name='sessionUserName' value='"+ sessionUserName+"'/></td>\r\n"
				+ "					</tr>"
				+ "					<tr>\r\n"
				+ "						<td>Expense Date :</td>\r\n"
				+ "						<td><input type=\"date\" name=\"exp_date\"/></td>\r\n"
				+ "					</tr>"
				+ "					<tr>\r\n"
				+ "						<td>Expense Category :</td>\r\n"
				+ "						<td>\r\n"
				+ "							<select name=\"exp_category\">\r\n"
				+ "								<option value=\"1\">Food</option>\r\n"
				+ "								<option value=\"2\">Travels & Fuel</option>\r\n"
				+ "								<option value=\"3\">Households & Grocery</option>\r\n"
				+ "								<option value=\"4\">Clothes & Accessories</option>\r\n"
				+ "								<option value=\"5\">Medicine & Hospital</option>\r\n"
				+ "								<option value=\"6\">Internet & Recharges & Power</option>\r\n"
				+ "								<option value=\"7\">Education</option>\r\n"
				+ "								<option value=\"8\">Gifts & Donations</option>\r\n"
				+ "								<option value=\"9\">Entertainment</option>\r\n"
				+ "								<option value=\"10\">Loans & Repayments</option>\r\n"
				+ "								<option value=\"11\">Others</option>\r\n"
				+ "							</select>\r\n"
				+ "						</td>\r\n"
				+ "					</tr>"
				+ "					<tr>\r\n"
				+ "						<td>Expense Details :</td>\r\n"
				+ "						<td><input type=\"text\" name=\"exp_desc\"/></td>\r\n"
				+ "					</tr>"
				+ "					<tr>\r\n"
				+ "						<td>Expense Amount :</td>\r\n"
				+ "						<td><input type=\"text\" name=\"exp_amount\"/></td>\r\n"
				+ "					</tr>"
				+ "					<tr>\r\n"
				+ "						<td colspan=\"2\" style=\"text-align: center\"><input type=\"submit\" value=\"Add Expense\"/></td>\r\n"
				+ "					</tr>\r\n"
				+ "				</form>\r\n"
				+ "				<form action=\'LogoutServlet'\" method=\"\" >\r\n"
				+ "					<tr>\r\n"
				+ "						<td colspan=\"2\" style=\"text-align: center\"><input type=\"submit\" value=\"LogOut\"/></td>\r\n"
				+ "					</tr>"
				+ "				</form>\r\n"
				+ "				</table>\r\n"
				+ "			\r\n"
				+ "		</div>");
		
		
			String username=(String) req.getSession().getAttribute("userid");
			
			DBConfiguration DB = new DBConfiguration();
			Connection con = DB.DBConfig();
			String sql ="select * from expenses where UserID=? ORDER BY exp_date DESC";
			try {
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, username);
				ResultSet rs = pst.executeQuery();
				 
				pw.println("<html><body><table border=\"1\">");
				pw.println("<tr><th>Date</th><th>exp category</th><th>Description</th><th>Amount</th></tr>");
				while(rs.next())  {
					pw.println("<tr>");
					pw.println("<td>"+rs.getString("exp_date")+"</td>");
					pw.println("<td>"+rs.getString("exp_cat")+"</td>");
					pw.println("<td>"+rs.getString("exp_des")+"</td>");
					pw.println("<td>"+rs.getString("exp_amount")+"</td>");
				    pw.println("</tr>");
				}
				pw.println("</table></body></html>");
				
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}