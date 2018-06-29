package com.martin.advanced.database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCConnectionProperties {

	public static void main(String[] args) {

		Connection myConn = null;				

		try {

			// 1. Load the properties file
			Properties props = new Properties();
			props.load(new FileInputStream("demo.properties"));
			// props.load(new FileInputstream("c:/temp/demo.properties");

			// 2. Read the props
			String theUser = props.getProperty("user");
			String thePassword = props.getProperty("password");
			String theDburl = props.getProperty("dburl");

			System.out.println("Connecting to database...");
			System.out.println("Database URL: " + theDburl);
			System.out.println("User: " + theUser);

			// 3. Get a connection to database
			myConn = DriverManager.getConnection(theDburl, theUser, thePassword);
			
			System.out.println("\nConnection successful!\n");
			
			showEmployees(myConn);
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void showEmployees(Connection myConn) {
		try {
			Statement stmt = myConn.createStatement();
			String sql = "select first_name, last_name from demo.employees";
			ResultSet result = stmt.executeQuery(sql);
			
			while(result.next()) {
				String name = result.getString("first_name");
				String surname = result.getString("last_name");
				System.out.println(name + ", " + surname);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
