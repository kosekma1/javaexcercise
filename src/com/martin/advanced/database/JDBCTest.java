package com.martin.advanced.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
		
	static final String DB_URL = "jdbc:mysql://localhost:3306/demo?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Prague";
	
	static final String USER = "student";
	static final String PASS = "student";
	
	//static final String USER = "root";
	//static final String PASS = "";
	
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
									
			// open connection									
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
						
			// create query
			stmt = conn.createStatement();
			String sql = "SELECT * FROM employees";
			
			// execute query
			rs = stmt.executeQuery(sql);
			
			// extract data from resultset			
			while(rs.next()) { // moves forward one row, returns true if there are more rows
				// retrieve by column name
				int id = rs.getInt("id");
				String first = rs.getString("first_name");
				String last = rs.getString("last_name");				
				String email = rs.getString("email");
				String department = rs.getString("department");
				double salary = rs.getDouble("salary");
				
				//display values
				System.out.println(id + "\t" + first + "\t" + last + "\t" + email + "\t " + department + "\t " + salary);																
			}
			
			// insert data into database
			sql = "INSERT INTO employees (last_name, first_name, email, department, salary)" +
			"values " + "('Wright', 'Eric', 'eric.wright@foo.com', 'HR', 33000.00)";
			int rowsAffected = stmt.executeUpdate(sql);			
			
			System.out.println("INSERTING... " + rowsAffected + " rows updated");
			
			// update data in a database
			sql = "UPDATE employees " + 
			"set email='eric.wright@gmail.com' " +
			"where last_name='Wright' and first_name='Eric'";
			rowsAffected = stmt.executeUpdate(sql);
			
			System.out.println("UPDATING... " + rowsAffected + " rows updated");
			
			// delete data in a database
			sql = "DELETE from employees " +
			"where last_name='Wright' and first_name='Eric'";
			rowsAffected = stmt.executeUpdate(sql);
			
			System.out.println("DELETING... " + rowsAffected + " rows updated");
			
			// prepared statement
			sql = "SELECT * FROM employees " + 
			"WHERE salary > ? and department=?";
			
			/* sql = "DELETE FROM employees " + 
					"WHERE salary > ? and department=?"; 
			
			// in case DELETE you have to call preparedStmt.executeUpdate();
			*/
			
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setDouble(1, 80000);
			preparedStmt.setString(2, "Legal");
			
			rs = preparedStmt.executeQuery();
			
			System.out.println("PREPARED STATEMENT");
			while(rs.next()) {
				System.out.println(rs.getString("last_name") + ", " + rs.getString("first_name") +
						", " + rs.getDouble("salary") + ", " + rs.getString("department"));				
			}
			
			rs.close();
			conn.close();
							
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//usually close connection			
		}
		
	}

}
