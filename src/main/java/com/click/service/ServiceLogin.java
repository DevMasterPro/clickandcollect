package com.click.service;

import java.sql.ResultSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceLogin {

	@Autowired
	DataBaseConnection connection;
	public void SaveLogin(String userid, String pass, String type) {
		// TODO Auto-generated method stub
		try {
			connection.getConnections();
			connection.stmt = connection.con.createStatement();
			connection.stmt.executeUpdate("Insert into Login (password,userid,type) value ('" + pass + "','" + userid + "','"+type+"')");
			connection.con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	public String getUserId(String email,String Table) {
		String ID = "";
		try {
			connection.getConnections();
			connection.stmt = connection.con.createStatement();
			ResultSet rs = connection.stmt.executeQuery("select ID from "+Table+" where Email ='" + email + "'");
			while (rs.next())
				ID = rs.getString(1);
			connection.con.close();
		} catch (Exception Ex) {
			System.out.println(Ex.getMessage());
		}
		return ID;
	}

	
	public int getEmail(String email, String Table) {
		int count = 0;
		try {
			connection.getConnections();
			connection.stmt = connection.con.createStatement();
			ResultSet rs = connection.stmt.executeQuery("select count(*) from "+Table+" where Email ='" + email + "'");
			while (rs.next())
				count = rs.getInt(1);
			connection.con.close();
		} catch (Exception Ex) {
			System.out.println(Ex.getMessage());

		}
		return count;
	}

	public int Login(String userid, String password,String type) {
		int count = 0;
		try {
			connection.getConnections();
			connection.stmt = connection.con.createStatement();
			ResultSet rs = connection.stmt.executeQuery(
					"select count(*) from login where userid ='" + userid + "' and password ='" + password + "' and type = '"+type+"'");
			while (rs.next())
				count = rs.getInt(1);
			// name += ""+ rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3) +"";
			System.out.println("connection 4");
			connection.con.close();
		} catch (Exception Ex) {
			System.out.println(Ex.getMessage());

		}
		return count;
	}

	public int EmailExists(String email, String table) {
		int count = 0;
		try {
			connection.getConnections();
			connection.stmt = connection.con.createStatement();
			ResultSet rs = connection.stmt.executeQuery("select count(*) from "+table+"  where Email ='" + email + "'");
			while (rs.next())
				count = rs.getInt(1);
			connection.con.close();
		} catch (Exception Ex) {
			System.out.println(Ex.getMessage());

		}
		return count;
		
	}

	public String getName(String email, String table) {
		String name = "";
		try {
			connection.getConnections();
			connection.stmt = connection.con.createStatement();
			ResultSet rs = connection.stmt.executeQuery("select Firstname from "+table+" where Email ='" + email + "'");
			while (rs.next())
				name = rs.getString(1);
			connection.con.close();
		} catch (Exception Ex) {
			System.out.println(Ex.getMessage());
		}
		return name;
	}
	
	
	
	
	
	
	
	
}
