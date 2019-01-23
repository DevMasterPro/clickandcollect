package com.click.object;

public class SellOrderlineObject {
	public String Productname;
	public String Firstname;
	public String Lastname;
	public String Storename;
	public String sellerid;
	public String orderlineid;
	public String status;
	
	public SellOrderlineObject(String productname, String firstname, String lastname, String storename, String sellerid,
			String orderlineid, String status) {
		super();
		Productname = productname;
		Firstname = firstname;
		Lastname = lastname;
		Storename = storename;
		this.sellerid = sellerid;
		this.orderlineid = orderlineid;
		this.status = status;
	}


	
	
	public String getProductname() {
		return Productname;
	}
	public void setProductname(String productname) {
		Productname = productname;
	}
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLastname(String lastname) {
		Lastname = lastname;
	}
	public String getStorename() {
		return Storename;
	}
	public void setStorename(String storename) {
		Storename = storename;
	}
	public String getSellerid() {
		return sellerid;
	}
	public void setSellerid(String sellerid) {
		this.sellerid = sellerid;
	}
	public String getOrderlineid() {
		return orderlineid;
	}
	public void setOrderlineid(String orderlineid) {
		this.orderlineid = orderlineid;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
