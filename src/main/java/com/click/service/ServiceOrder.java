package com.click.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.click.object.OrderObject;
import com.click.object.StoreObject;

@Service
public class ServiceOrder {

	@Autowired
	DataBaseConnection connection;
	
	
	
	public List<OrderObject> Orders = new ArrayList<>();
	 
	 
	//this method is called when the user tries get list of orders from the database
	 public void getOrder(String column,String ID) {
		 try {
			connection.getConnections();
			connection.stmt = connection.con.createStatement();
			ResultSet rs = connection.stmt.executeQuery("select * from orders where "+ column +" = '"+ID+"' ORDER BY ID DESC");  
			while(rs.next())  {
				Orders.add(new OrderObject(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));		
			}
			connection.con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
	 }
	//this method is called when the user tries to view all the orders
		
	public List<OrderObject> retrieveOrder() {
		
	     return Orders;
	 }
	 
	//this method is called when the user tries to view a list of order based on orderid
	public List<StoreObject> retrievesingle(String id) {
		 List<StoreObject> listitem = new ArrayList<>();
	    for (OrderObject t : Orders ) {
	        
	    }
	    return listitem;
	}


	public void clearData() {
		
		Orders.clear();
	}
	
	
}
