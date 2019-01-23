package com.click.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.click.object.SellOrderlineObject;

@Service
public class ServiceSellerViewOrder {
	@Autowired
	DataBaseConnection connection;
	
	public List<SellOrderlineObject> sellerorders = new ArrayList<>();
	 
	 
	//this method is called when the seller tries list the orders from database 
	 public void getSellerOrders(String sellerid) {
		 try {
			connection.getConnections();
			connection.stmt = connection.con.createStatement();
			ResultSet rs = connection.stmt.executeQuery("select * from sellerorder where sellerid = '"+sellerid+"'");  
			while(rs.next())  {
				sellerorders.add(new SellOrderlineObject(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));		
			}
			connection.con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
	 }
	//this method is called when the user tries to retrieve all their orders
		
	public List<SellOrderlineObject> retrieveSellerOrder() {
		
	     return sellerorders;
	 }
	 


	public void clearData() {
		
		sellerorders.clear();
	}

	public void updateorderLine(String id) {
		// TODO Auto-generated method stub
		
		try {
			connection.getConnections();
			connection.stmt = connection.con.createStatement();
			connection.stmt.executeUpdate("Update Ordersline set status ='Y' where ID ="+id+"");  
			connection.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
}
