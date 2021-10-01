package com.customerRegistration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = request.getParameter("firstName");
		String lastName  = request.getParameter("lastName");
		String country =  request.getParameter("country");
		String city =  request.getParameter("city");
		String state =  request.getParameter("state");
		String address =  request.getParameter("address");
		String zip =  request.getParameter("zipCode");
		String phone =  request.getParameter("phone");
		String userID =  request.getParameter("userID");
		String password =  request.getParameter("userPassword");
		
		User user = new User(firstName, lastName, country, city, state, address, zip, phone, userID, password);
		
		
		UserDAO userDAO = new UserDAO(MyConnection.createConnection());
		
		if(userDAO.registerUser(user) != false) {
			response.sendRedirect("index.jsp");
		}
		else {
			String errorMessage = "Cannot register !!";
			HttpSession regHttpSession = request.getSession();
			regHttpSession.setAttribute("RegError", errorMessage);
			response.sendRedirect("Registration.jsp");
			
		}
	}

}
