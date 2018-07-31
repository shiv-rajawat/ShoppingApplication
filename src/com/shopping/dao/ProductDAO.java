package com.shopping.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.shopping.model.Product;

public class ProductDAO {

	public List<Product> showProducts() throws SQLException {
		List<Product> productList = new ArrayList<Product>();
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingApplication", "root", "root");
			PreparedStatement ps = con.prepareStatement("select * from productdetails");

			ResultSet rst;
			rst = ps.executeQuery();
			while (rst.next()) {
				int productID = rst.getInt("productID");
				String name = rst.getString("productname");
				int quantity = rst.getInt("quantity");
				int price = rst.getInt("price");

				Product product = new Product(productID, name, quantity, price);

				productList.add(product);
			}

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		} finally {
			con.close();
		}
		return productList;

	}
}
