package com.click.object;

public class ShoppingObject {
	public String ID;
	public String name;
	public String price;
	public String quantity;
	public int total;
	public int totalOfAll;
	public String storeid;

	
	public ShoppingObject(String iD, String name, String price, String quantity, int total, String storeid) {
		super();
		ID = iD;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.total = total;
		this.storeid = storeid;
	}



	public String getStoreid() {
		return storeid;
	}

	public void setStoreid(String storeid) {
		this.storeid = storeid;
	}


	public ShoppingObject() {
		// TODO Auto-generated constructor stub
	}

	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	public int getTotalOfAll() {
		return totalOfAll;
	}

	public void setTotalOfAll(int totalOfAll) {
		
		this.totalOfAll += getTotal();
	}
	
	

}
