package com.click.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;


import org.springframework.stereotype.Service;

@Service
public class DataBaseConnection {
	

	public static Connection con = null;
	public static java.sql.Statement stmt;

	// this methods creates a connection
	public static Connection getConnections() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); //
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clickandcollect", "root", "Sayarun12");

			System.out.println("connection Successfull");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return con;
	}

	
	
	

}
