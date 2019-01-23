package com.click.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.click.object.StoreObject;

@Service
public class ServiceStore {
	
	@Autowired
	DataBaseConnection connection;
//Creates a record in the store db table
	public void SaveCreateStore(String sname, String email, String phonenum, String add1, String add2, String city,
			String postcode, String sellerId) {
	
		try {
			connection.getConnections();
			connection.stmt = connection.con.createStatement();
			connection.stmt.executeUpdate(
					"Insert into Store (Storename,Email, AddressLine1,AddressLine2,City,Postcode,Telephone,sellerid) value ('" + sname + "','" + email + "','" + add1 + "','" + add2 + "','" + city + "','"
							+ postcode + "','" + phonenum + "','"+sellerId+"')");
			connection.con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	
	
	 public List<StoreObject> addStore = new ArrayList<>();
	 
	 
	//this method is called when the user tries get list of Store
	 public void getStore() {
		 try {
			connection.getConnections();
			connection.stmt = connection.con.createStatement();
			ResultSet rs = connection.stmt.executeQuery("select * from store");  
			while(rs.next())  {
				addStore.add(new StoreObject(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));		
			}
			connection.con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
	 }
	//this method is called when the user tries to view all the specialist
		
	public List<StoreObject> retrieveStore() {
		
	     return addStore;
	 }
	 
	//this method is called when the user tries to view a list of store based on a Seller ID
	public List<StoreObject> retrieveStoreBasedOnID(String id) {
		 List<StoreObject> listitem = new ArrayList<>();
	    for (StoreObject t : addStore ) {
	        if (t.getSellerid().equals(id)) {     	
	       	 	listitem.add(t);
	            
	        }
	    }
	    return listitem;
	}


	public void clearData() {
		
		addStore.clear();
	}
	
	
	public void getStoreforPostcode(String value) {
		 try {
			connection.getConnections();
			connection.stmt = connection.con.createStatement();
			ResultSet rs = connection.stmt.executeQuery("select * from store where Postcode like '"+value+"%'");  
			while(rs.next())  {
				addStore.add(new StoreObject(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));		
			}
			connection.con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
	 }
	
	public int getStoreCount(String value) {
		int count =0;
		 try {
			connection.getConnections();
			connection.stmt = connection.con.createStatement();
			ResultSet rs = connection.stmt.executeQuery("select count(*) from store where Postcode like '"+value+"%'");  
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
