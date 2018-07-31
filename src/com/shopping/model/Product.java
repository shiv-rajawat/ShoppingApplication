package com.shopping.model;

public class Product 
{
	
	public Product(int productID,String productName, int quantity, int price) 
	{
		// TODO Auto-generated constructor stub
		this.productID = productID;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
		
	}
	
	private int productID;
	private String productName;
	private int quantity;
	private int price;
	
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
