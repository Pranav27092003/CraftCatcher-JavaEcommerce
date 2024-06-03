package com.entity;

public class ItemOrder {
	private int id;
	private String orderid;
	private String username;
	private String email;
	private String phno;
	private String fullAddress;
	private String itemname;
	private String price;
	private String paymentType;
	public ItemOrder() {		
		super();
	}
	
	
	public int getId() {
		return id;
	}
	
	
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getFullAddress() {
		return fullAddress;
	}
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	@Override
	public String toString() {
		return "ItemOrder [id=" + id + ", orderid=" + orderid + ", username=" + username + ", email=" + email
				+ ", phno=" + phno + ", fullAddress=" + fullAddress + ", paymentType=" + paymentType + "]";
	}
		
}
