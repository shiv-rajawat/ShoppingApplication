package com.shopping.dao;
import java.sql.*;

public class OrderDAO {
	public void ValidateOrder(int productSelectedID, int inputQuantity) throws SQLException {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingApplication", "root", "root");
			PreparedStatement ps = con.prepareStatement(
					"Update productdetails set quantity = quantity-? where productID = ? and quantity>0");
			ps.setInt(1, inputQuantity);
			ps.setInt(2, productSelectedID);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}
}
