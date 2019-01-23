package com.click.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service_Contact {

		@Autowired 
		DataBaseConnection connection;
		
	public void SaveContactInfo(String name, String email, String comments) {
		// TODO Auto-generated method stub
		
		try {
			connection.getConnections();
			connection.stmt = connection.con.createStatement();
			connection.stmt.executeUpdate(
					"Insert into contact (name,email,description, status) value ('"
							+ name + "','" + email + "','" + comments + "','N')");
			connection.con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}

		
		
		
	}

	
	
	
	
	
}
