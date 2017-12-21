package com.omkarsh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) 
	{
		String driverName = "com.mysql.jdbc.Driver";
		String jdbcUrl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user="hbstudent";
		String pass="hbstudent";
		
		try{
			Class.forName(driverName);
			System.out.println("Connecting to database "+jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl,user,pass);
			
			System.out.println("Connection Successful");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
