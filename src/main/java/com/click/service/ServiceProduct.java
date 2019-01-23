package com.click.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.click.object.ProductObject;

@Service
public class ServiceProduct {

	@Autowired
	DataBaseConnection connection;

	public void createProduct(String storeid, String productname, String productinfo, String productdesc, String image,
			String cost) {
		
		try {
			connection.getConnections();
			connection.stmt = connection.con.createStatement();
			connection.stmt.executeUpdate(
					"Insert into Product (Productname,Productinfo, Productdesc,Image,Price,Stroreid) value ('" + productname + "','" + productinfo + "','" + productdesc + "','" + image + "','" + cost + "','"
							+ storeid + "')");
			connection.con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		
	}
	
	public List<ProductObject> addProduct = new ArrayList<>();
	 
	 
	//this method is called when the user tries get list of Product
	 public void getProductBasedOnStoreID(String Value) {
		 try {
			connection.getConnections();
			connection.stmt = connection.con.createStatement();
			ResultSet rs = connection.stmt.executeQuery("select * from Product where Stroreid = '"+Value+"'");  
			while(rs.next())  {
				addProduct.add(new ProductObject(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));		
			}
			connection.con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
	 }
	//this method is called when the user tries to view all the Product
		
	public List<ProductObject> retrieveProduct() {
		
	     return addProduct;
	 }
	 
	//this method is called when the user tries to view a list of product based on a product ID
	public List<ProductObject> retrieveProductBasedOnID(String id) {
		 List<ProductObject> listitem = new ArrayList<>();
	    for (ProductObject t : addProduct ) {
	        if (t.getID().equals(id)) {     	
	       	 	listitem.add(t);
	            
	        }
	    }
	    return listitem;
	}


	public void clearData() {
		
		addProduct.clear();
	}
	
	
	public void getProductBasedOnproductName(String Value, String id) {
		 try {
			connection.getConnections();
			connection.stmt = connection.con.createStatement();
			ResultSet rs = connection.stmt.executeQuery("select * from Product where Stroreid = '"+id+"' and Productname like '"+Value+"%';");  
			while(rs.next())  {
				addProduct.add(new ProductObject(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));		
			}
			connection.con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
	 }
	
	

	public int getProductCount(String value) {
		int count =0;
		 try {
			connection.getConnections();
			connection.stmt = connection.con.createStatement();
			ResultSet rs = connection.stmt.executeQuery("select count(*) from store where Productname like '"+value+"%'");  
			while(rs.next())  {
				count =rs.getInt(1);
			}
			connection.con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return count;
		 
	 }

	public String getStorename(String id) {
		// TODO Auto-generated method stub
		
		String name="";
		 try {
			connection.getConnections();
			connection.stmt = connection.con.createStatement();
			ResultSet rs = connection.stmt.executeQuery("select Storename from store where id = "+id+"");  
			while(rs.next())  {
				name = rs.getString(1);
			}
			connection.con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return name;
		
		
	}
	
	public int getProductCountBasedOnID(String ID) {
		int count =0;
		 try {
			connection.getConnections();
			connection.stmt = connection.con.createStatement();
			ResultSet rs = connection.stmt.executeQuery("select count(*) from Product where Stroreid = '"+ID+"'");  
			while(rs.next())  {
				count =rs.getInt(1);
			}
			connection.con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return count;
		 
	 }
	
	
	
	
	
}


