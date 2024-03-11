package com.yashu.project.expenses;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession();
		session.invalidate();
		resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        resp.setHeader("Expires", "0");
		out.println("You have successfully Logged out.");
		resp.sendRedirect("User_Login.html");
		
	}
}
