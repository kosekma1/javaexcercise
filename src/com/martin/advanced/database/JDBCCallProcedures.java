package com.martin.advanced.database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCCallProcedures {
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/demo?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Prague";
	
	static final String USER = "student";
	static final String PASS = "student";

	public static void main(String[] args) {
		Connection myConn = null;
		CallableStatement myStmt = null;
		
		
			try {
				myConn = DriverManager.getConnection(DB_URL, USER, PASS);
				
				String theDepartment = "Engineering";
				int theIncreaseAmount = 10000;
				
				System.out.println("Salaries BEFORE\n");
				
				showSalaries(myConn, theDepartment);
				
				myStmt = myConn.prepareCall("{call increase_salaries_for_department(?, ?)}");
				
				myStmt.setString(1, theDepartment);
				myStmt.setDouble(2, theIncreaseAmount);
				
				System.out.println("\n\nCalling stored procedure. increase_salaries_for_department('" + theDepartment + "', " + theIncreaseAmount + ")"); 
				myStmt.execute();
				System.out.println("Finished calling stored procedure");
				
				System.out.println("\n\nSalaries AFERT\n");
				showSalaries(myConn, theDepartment);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		

		
	}

	public static void showSalaries(Connection myConn, String theDepartment) {
		
		try {
			Statement stmt = myConn.createStatement();
			String sql = "SELECT * FROM employees WHERE department='" + theDepartment + "'";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getString("last_name") + ", " + rs.getString("first_name") + ", " + rs.getDouble("salary"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

}
