package com.shopping.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.model.User;
import com.shopping.service.ValidateUserService;

/**
 * Servlet implementation class ValidateLoginServlet
 */
@WebServlet("/ValidateLoginServlet")
public class ValidateLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 * This servlet fetches the user input from the jsp page and renders it to service class for valuation.
	 * It then redirects to either home page or back to login page based on the status returned by the function of the service class. 
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
		boolean status = false;
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		User user = new User(userName, password);
		ValidateUserService loginService = new ValidateUserService();
			status = loginService.serviceLoginInfo(user);

		if (status) {
			PrintWriter out = response.getWriter();
			out.println("In status");
			HttpSession session = request.getSession();
			session.setAttribute("user", userName);
			session.setMaxInactiveInterval(10);
			RequestDispatcher rd = request.getRequestDispatcher("HomePage.jsp");
			rd.include(request, response);
		}
		 else {
			PrintWriter out = response.getWriter();
			out.println("Invalid details.. Try again ");
			RequestDispatcher rd = request.getRequestDispatcher("UserLogin.jsp");
			rd.include(request, response);

		}
		
		
		//doGet(request, response);
	}

}
