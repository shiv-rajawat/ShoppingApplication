package com.shopping.model;

public class User
{
	private int userID;
	private String username;
	private String password;
	private String address;
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public User(String username, String password )
	{
		this.username = username;
		this.password = password;
		// TODO Auto-generated constructor stub
		
	}
	
}