package com.click.object;

public class StoreObject {
	
	private String ID;
	private String Storename;
	private String Email;
	private String AddressLine1;
	private String AddressLine2;
	private String City;
	private String Postcode;
	private String Telephone;
	private String sellerid;
	
	
	public StoreObject(String iD, String storename, String email, String addressLine1, String addressLine2, String city,
			String postcode, String telephone, String sellerid) {
		super();
		ID = iD;
		Storename = storename;
		Email = email;
		AddressLine1 = addressLine1;
		AddressLine2 = addressLine2;
		City = city;
		Postcode = postcode;
		Telephone = telephone;
		this.sellerid = sellerid;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getStorename() {
		return Storename;
	}
	public void setStorename(String storename) {
		Storename = storename;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAddressLine1() {
		return AddressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		AddressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return AddressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		AddressLine2 = addressLine2;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getPostcode() {
		return Postcode;
	}
	public void setPostcode(String postcode) {
		Postcode = postcode;
	}
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		Telephone = telephone;
	}
	public String getSellerid() {
		return sellerid;
	}
	public void setSellerid(String sellerid) {
		this.sellerid = sellerid;
	}

	
	
}
