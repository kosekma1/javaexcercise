package com.martin.advanced.database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class JDBCTransactions {
	
	
	/* by default, the database connection is set to auto-commit
	 * Need explicitly turn off auto-commit
	 * 
	 */
	
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/demo?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Prague";
	
	static final String USER = "root";
	static final String PASS = "";

	public static void main(String[] args) {
		Connection myConn = null;
		Statement myStmt = null;
		
		
			try {
				myConn = DriverManager.getConnection(DB_URL, USER, PASS);
				myConn.setAutoCommit(false);											
				
				System.out.println("Salaries BEFORE \n");
				showSalaries(myConn, "HR");
				showSalaries(myConn, "Engineering");
				
				// Transaction Step 1: Delete all HR employees
				myStmt = myConn.createStatement();
				myStmt.executeUpdate("DELETE FROM employees WHERE department='HR'");
				
				// Transaction Step 2: Set salaries to 3000000 for all Engineering
				myStmt.executeUpdate("UPDATE employees SET salary=3000000 where department='Engineering'");
				
				System.out.println("\n >> Transaction steps are ready.\n");
				
				System.out.println("Is transaction ready? y/n");
				
				boolean ok = true;
				
				if(ok) {
					// store in database
					myConn.commit();
					System.out.println("\n>> Transaction COMMITTED.\n");
				} else {
					// discard
					System.out.println("\n>> Transaction ROLLED BACK.\n");
				}
				
				// Show salaries AFTER
				System.out.println("Salaries AFTER\n");
				showSalaries(myConn, "HR");
				showSalaries(myConn, "Engineering");																
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
	public static void showSalaries(Connection myConn, String department) {
		
		try {
			Statement stmt = myConn.createStatement();
			String sql = "SELECT * FROM employees WHERE department='" + department + "'";
			ResultSet myRs = stmt.executeQuery(sql);
			
			while(myRs.next()) {
				System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name") + ", " + myRs.getDouble("salary"));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		


}
