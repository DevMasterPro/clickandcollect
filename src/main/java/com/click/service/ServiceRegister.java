package com.click.service;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceRegister {

	@Autowired
	DataBaseConnection connection;
//Creating a record in the Customer table with the customer info
	public void SaveUserRegister(String fname, String sname, String email, String phonenum, String add1, String add2,
			String city, String postcode) {
		try {
			connection.getConnections();
			connection.stmt = connection.con.createStatement();
			connection.stmt.executeUpdate(
					"Insert into customer (Firstname,Lastname,Email, AddressLine1,AddressLine2,City,Postcode,Telephone,disable) value ('"
							+ fname + "','" + sname + "','" + email + "','" + add1 + "','" + add2 + "','" + city + "','"
							+ postcode + "','" + phonenum + "','No')");
			connection.con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}
	//Creating a record in the Seller table with the Seller info
	public void SaveSellerRegister(String fname, String sname, String email, String phonenum, String add1, String add2,
			String city, String postcode) {
		try {
			connection.getConnections();
			connection.stmt = connection.con.createStatement();
			connection.stmt.executeUpdate(
					"Insert into Seller (Firstname,Lastname,Email, AddressLine1,AddressLine2,City,Postcode,Telephone,disable) value ('"
							+ fname + "','" + sname + "','" + email + "','" + add1 + "','" + add2 + "','" + city + "','"
							+ postcode + "','" + phonenum + "','No')");
			connection.con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

}
