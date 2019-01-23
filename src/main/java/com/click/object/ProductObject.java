package com.click.object;

public class ProductObject {
	private String ID;
	private String  Productname ;
	private String  Productinfo ;
	private String  Productdesc;
	private String  Image;
	private String  Price;
	private String  Stroreid;
	
	
	public ProductObject(String iD, String productname, String productinfo, String productdesc, String image,
			String price, String stroreid) {
		super();
		ID = iD;
		Productname = productname;
		Productinfo = productinfo;
		Productdesc = productdesc;
		Image = image;
		Price = price;
		Stroreid = stroreid;
	}

	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getProductname() {
		return Productname;
	}
	public void setProductname(String productname) {
		Productname = productname;
	}
	public String getProductinfo() {
		return Productinfo;
	}
	public void setProductinfo(String productinfo) {
		Productinfo = productinfo;
	}
	public String getProductdesc() {
		return Productdesc;
	}
	public void setProductdesc(String productdesc) {
		Productdesc = productdesc;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getStroreid() {
		return Stroreid;
	}
	public void setStroreid(String stroreid) {
		Stroreid = stroreid;
	}

	

}
