package com.assignment;

import java.io.IOException;
import java.io.PrintWriter;


import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class Arithmetic extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int i = Integer.parseInt(req.getParameter("num1"));
		String operator = req.getParameter("operators");
		int j = Integer.parseInt(req.getParameter("num2"));	
		PrintWriter out = res.getWriter();
		if("add".equals(operator)) {
			out.println (i+j);
		}
		else if ("sub".equals(operator)) {
			out.println(i-j);
		}
		else if ("mul".equals(operator)) {
			out.println(i*j);
		}
		else if ("div".equals(operator)) {
			if (j > 0) {
				out.println(i/j);
			}
			else {
				out.println("Division by ZERO is not valid.");
			}
		}
		else {
			out.println("Invalid Operator");
		}
	}
}



