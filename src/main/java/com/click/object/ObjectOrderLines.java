package com.click.object;


public class ObjectOrderLines {

	public String  Productid;
	 public String orderid;
	 public String price;
	 public String storeid;
	 public String quantity;
	 public String orderdate;
   
   
   
   public ObjectOrderLines(String iD, String productid, String orderid, String price, String storeid, String quantity,
			String orderdate) {
		super();
		ID = iD;
		Productid = productid;
		this.orderid = orderid;
		this.price = price;
		this.storeid = storeid;
		this.quantity = quantity;
		this.orderdate = orderdate;
	}
public String	ID;
	 public String getID() {
	return ID;
}
public void setID(String iD) {
	ID = iD;
}
public String getProductid() {
	return Productid;
}
public void setProductid(String productid) {
	Productid = productid;
}
public String getOrderid() {
	return orderid;
}
public void setOrderid(String orderid) {
	this.orderid = orderid;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getStoreid() {
	return storeid;
}
public void setStoreid(String storeid) {
	this.storeid = storeid;
}
public String getQuantity() {
	return quantity;
}
public void setQuantity(String quantity) {
	this.quantity = quantity;
}
public String getOrderdate() {
	return orderdate;
}
public void setOrderdate(String orderdate) {
	this.orderdate = orderdate;
}
	
	
}
