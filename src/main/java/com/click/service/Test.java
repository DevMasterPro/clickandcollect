package com.click.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.click.object.StoreObject;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		

		DataBaseConnection connection = new DataBaseConnection();
		
		try {
			connection.getConnections();
			connection.stmt = connection.con.createStatement();
			ResultSet rs = connection.stmt.executeQuery("select * from sellerorder where status ='N' and sellerid ='5'");  
			while(rs.next())  {
					System.out.println(rs.getString(1));
			}
			connection.con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
