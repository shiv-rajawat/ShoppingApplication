
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.File"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.shopping.model.Product"%>
<%@ page import="com.shopping.dao.*"%>
<%@ page import="com.shopping.service.DisplayProductListService"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<%
		if (session != null) {
			if (session.getAttribute("user") != null) {
				String userName = (String) session.getAttribute("user");
				out.print("Welcome, " + userName);
			} else {
				response.sendRedirect("UserLogin.jsp");
			}
		}
	%>
	<% 
	List<Product> productList = new ArrayList<Product>();

		DisplayProductListService dlist = new DisplayProductListService();
		productList = dlist.showList();

		request.setAttribute("list", productList);
	%>
		
	<table border=1>
		<tr>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Product Available Quantity</th>
			<th>Product Price</th>
			<th>Quantity</th>
			<th>Action</th>
		</tr>
		<%
			if (request.getAttribute("list") != null) {
				ArrayList<Product> products = (ArrayList<Product>)request.getAttribute("list");
				for (Product product : products) {
		%>

		<tr>
			<td><%=product.getProductID()%></td>
			<td><%=product.getProductName()%></td>
			<td><%=product.getQuantity()%></td>
			<td><%=product.getPrice()%></td>
			
			<td>
				<form method="post" action="CheckoutServlet">
				<input type="number" id="inputQuantity" name="inputQuantity"
           placeholder="20 increments" placeholder="Min: 10, max: 100"
           min="0" max="100" step="1" /> 
			</td>
			<td>
				
					<button type="submit" name="selectedID"
						value=<%=product.getProductID()%>>Buy Now</button>
				</form>
			</td>

		</tr>
		<%
			}
			}
		%>


</table>
</body>
</html>
