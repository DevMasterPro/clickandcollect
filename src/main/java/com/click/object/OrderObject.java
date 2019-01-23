package com.click.object;

public class OrderObject {
	   
	
	   public String ID;
	   public String total;
	   public String customerid;
	   public String orderdate;
	
	
	   public OrderObject(String iD, String total, String customerid, String orderdate) {
		super();
		ID = iD;
		this.total = total;
		this.customerid = customerid;
		this.orderdate = orderdate;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	



	
}
