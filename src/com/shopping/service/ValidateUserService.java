/* This service class passes the login information to the data access object.*/

package com.shopping.service;

import java.sql.SQLException;

import com.shopping.dao.UserDAO;
import com.shopping.model.User;

public class ValidateUserService {
	public boolean serviceLoginInfo(User user)  {
		boolean status = false;
		UserDAO userdao = new UserDAO();
		try {
			status = userdao.sendLoginDb(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;

	}

}
