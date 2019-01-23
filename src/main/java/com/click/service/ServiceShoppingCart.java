package com.click.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.click.controller.Product;
import com.click.object.ShoppingObject;

@Service
public class ServiceShoppingCart {
	@Autowired
	DataBaseConnection connection;
	public List<ShoppingObject> addToShoppingObject = new ArrayList<>();
	 
	 
	//this method is called when the user tries add item to the shoping basket
	 public void getToBasket(String id, String name, String price, String Quantity, int total, String storeid) {
		 addToShoppingObject.add( new ShoppingObject(id,name,price,Quantity,total,storeid) );
		 System.out.println("Product Added");
	 }
	//this method is called when the user tries to view all the item on the shoppingbasket
		
	public List<ShoppingObject> retrieveShoppingcart() {
		
	     return addToShoppingObject;
	 }
	 
	//this method is called when the user tries to delete an item from the shopping basket
	public int deleteShoppingItem(String id) {
		int price=0;
		 try {
	    for (ShoppingObject t : addToShoppingObject ) {
	        if (t.getID().equals(id)) {     	
	        	    
	        	     price += t.getTotal();
	        	     addToShoppingObject.remove(t);
	        }

		    System.out.println(t.getName());
	    }
		 }
		 catch(Exception e) {
			 System.out.println(e.getMessage());
		 }
		 return price;
	}
	
	
	public int getTotal() {
		int price=0;
		 try {
	    for (ShoppingObject t : addToShoppingObject ) {
	        	     price += t.getTotal();
	    }
		 }
		 catch(Exception e) {
			 System.out.println(e.getMessage());
		 }
		 return price;
	}
	
	

	public void clearData() {		
		addToShoppingObject.clear();
	}

	public void submitorder(String id) {
		// TODO Auto-generated method stub
			int total = getTotal();
			String totals =  " " + total;
		try {
			connection.getConnections();
			connection.stmt = connection.con.createStatement();
			connection.stmt.executeUpdate(
					"Insert into Orders (total,customerid,orderdate) value ('"
							+ totals + "','" + id + "', NOW())");
			connection.con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
			
	}

	public String getOrderID(String id) {
		// TODO Auto-generated method stub
		
		String ID = "";
		try {
			connection.getConnections();
			connection.stmt = connection.con.createStatement();
			ResultSet rs = connection.stmt.executeQuery("select  ID from orders where customerid ='" + id + "' ORDER BY ID DESC LIMIT 1;");
			while (rs.next())
				ID = rs.getString(1);
			connection.con.close();
		} catch (Exception Ex) {
			System.out.println(Ex.getMessage());
		}
		return ID;
		
	}

	public void submitorderLine(String orderid, String ID) {
		// TODO Auto-generated method stub
		String status ="N";
	
		 try {
			 	for (ShoppingObject t : addToShoppingObject ) {
			    		connection.getConnections();
					connection.stmt = connection.con.createStatement();
					connection.stmt.executeUpdate(
							"Insert into Ordersline (Productid,orderid,price,storeid,quantity,orderdate,status,customerid) value ('"
									+ t.getID() + "','"+orderid +"','" + t.getPrice() + "','"+t.getStoreid()+"','"+t.getQuantity()+"', NOW(),'N','"+ID+"')");
				
			
			    	
			 	}
				connection.con.close();
				addToShoppingObject.clear();
		 }
		 catch(Exception e) {
			 System.out.println(e.getMessage());
		 }
		
		
		

		
	}
	
	public int getCount() {
		int count = addToShoppingObject.size();
		return count;
	}
	
	
	
	
}
