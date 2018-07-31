package com.shopping.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.service.CheckoutService;

/**
 * Servlet implementation class ProductDetailsServlet
 */
@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckoutServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *      This servlet gets the user selected product details and renders the service class to perform the required updates in the database accordingly.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productselID = request.getParameter("selectedID");
		String inpQuantity = request.getParameter("inputQuantity");
		PrintWriter out = response.getWriter();
		out.println("the selected id is " + productselID);
		out.println("the quantity required is "+inpQuantity);
		int productSelectedID = Integer.parseInt(productselID);
		int inputQuantity = Integer.parseInt(inpQuantity);
		CheckoutService checkoutservice = new CheckoutService();
		try {
			checkoutservice.PrepareOrder(productSelectedID, inputQuantity);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		// doGet(request, response);
	}

}
