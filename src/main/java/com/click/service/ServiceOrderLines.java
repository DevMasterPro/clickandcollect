package com.click.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.click.object.ObjectOrderLines;
import com.click.object.StoreObject;

@Service
public class ServiceOrderLines {

	@Autowired
	DataBaseConnection connection;
	
	public List<ObjectOrderLines> orderlines = new ArrayList<>();
	public List<orderitem> desc = new ArrayList<>();
	 
	//this method is called when the user tries get list orderlines from the database
	 public void getOrderLines(String id) {
		 try {
			connection.getConnections();
			connection.stmt = connection.con.createStatement();
			ResultSet rs = connection.stmt.executeQuery("select * from Ordersline where orderid ='"+id+"' ");  
			while(rs.next())  {
				orderlines.add(new ObjectOrderLines(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));		
			}
			connection.con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
	 }
	//this method is called when the user tries to view all the orderItem for an order ID
		
	public List<ObjectOrderLines> retrieveOrderLine() {
		
	     return orderlines;
	 }
	 
	//this method is called when the user tries to view a list of order item based on a order ID 
	public void retrieveSingleOrderLine() {
		try {
	    for (ObjectOrderLines t : orderlines ) {
	    
	    	String productName = this.getProductName(t.getProductid());
	    	String storename = this.getStoreName(t.getStoreid());
	    	
	    	desc.add(new orderitem(productName,storename,t.getPrice()));
	    
	    }
		}
		catch(Exception e) {
			System.out.println("i am in retrieveSingleOrderLine");
		}
	   
	}

	
	public List<orderitem> retrieveOrderItem() {
		
	     return desc;
	 }
public void cleardesc() {
	desc.clear();
	System.out.println("i am clearing items");
}
	public void clearData() {
		
		orderlines.clear();
	}
	
	
	
	public String getProductName(String productid) {
		String ID = "";
		try {
			connection.getConnections();
			connection.stmt = connection.con.createStatement();
			ResultSet rs = connection.stmt.executeQuery("select Productname from Product where ID ='" + productid + "'");
			while (rs.next())
				ID = rs.getString(1);
			connection.con.close();
		} catch (Exception Ex) {
			System.out.println(Ex.getMessage());
		}
		return ID;
	}

	
	public String getStoreName(String storeid) {
		String ID = "";
		try {
			connection.getConnections();
			connection.stmt = connection.con.createStatement();
			ResultSet rs = connection.stmt.executeQuery("select Storename from Store where ID ='" + storeid + "'");
			while (rs.next())
				ID = rs.getString(1);
			connection.con.close();
		} catch (Exception Ex) {
			System.out.println(Ex.getMessage());
		}
		return ID;
	}

	public void DeleteOrderItem() {
		// TODO Auto-generated method stub
		try {
		  for (orderitem t : desc ) {
			    
		    	desc.remove(t);
		    	System.out.println("deleted item");
		    }
		}
		catch(Exception e) {
			System.out.println("i am in DeleteOrderItem");
		}
	}
	
	
	
	
	
	
	
	
	
}
