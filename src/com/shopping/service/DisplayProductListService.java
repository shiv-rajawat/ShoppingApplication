package com.shopping.service;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import com.shopping.dao.ProductDAO;
import com.shopping.model.Product;
import java.util.List;

public class DisplayProductListService {
	public List<Product> showList() throws SQLException {

		ProductDAO pdao = new ProductDAO();
		return pdao.showProducts();

	}

}
