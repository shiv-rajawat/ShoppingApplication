/*This DAO validates the credentials from the database. */

package com.shopping.dao;

import java.sql.*;

import com.shopping.model.User;

public class UserDAO {
	public boolean sendLoginDb(User user) throws SQLException {
		boolean status = false;
		Connection con = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingApplication", "root", "root");

			PreparedStatement ps = con.prepareStatement("select * from user where username=? and pasword=?");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());

			ResultSet rs = ps.executeQuery();
			status = rs.next();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
		finally {
			con.close();
		}
		return status;

	}
}
