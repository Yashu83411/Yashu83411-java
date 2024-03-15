package com.registration.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.registration.dao.EmployeeDao;
import com.registration.model.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmployeeDao employeeDao = new EmployeeDao();
	
    /**
     * Default constructor. 
     */
    public EmployeeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/employeeregister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String id = request.getParameter("id");
		String Firstname = request.getParameter("Firstname");
		String Lastname = request.getParameter("Lastname");
		String Username = request.getParameter("Username");
		String Password = request.getParameter("Password");
		String Address = request.getParameter("Address");
		String Contact = request.getParameter("Contact");
	
	Employee employee = new Employee();
	
	employee.setid(id) ;
	employee.setFirstname(Firstname) ;
	employee.setLastname(Lastname);
	employee.setUsername(Username); 
	employee.setPassword(Password);
	employee.setAddress(Address);
	employee.setContact(Contact);
	
	try {
		employeeDao.registerEmployee(employee);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/employeedetails.jsp");
	dispatcher.forward(request, response);
	}

}
