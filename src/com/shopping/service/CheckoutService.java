package com.shopping.service;

import java.sql.SQLException;

import com.shopping.dao.OrderDAO;

public class CheckoutService 
{
	public void PrepareOrder(int productSelectedID, int inputQuantity) throws SQLException
	{
		OrderDAO orderdao = new OrderDAO();
		orderdao.ValidateOrder(productSelectedID,inputQuantity);
	} 
}
