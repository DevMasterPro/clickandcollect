package com.click.service;


public class orderitem {
	public orderitem(String productname, String storname, String price) {
		super();
		this.productname = productname;
		Storname = storname;
		this.price = price;
	}
	public String productname;
	public String Storname; 
	public String price;
	
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getStorname() {
		return Storname;
	}
	public void setStorname(String storname) {
		Storname = storname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	
	
}
