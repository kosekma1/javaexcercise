package com.martin.advanced.database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class JDBCCallProcedures {
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/demo?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Prague";
	
	static final String USER = "student";
	static final String PASS = "student";

	public static void main(String[] args) {
		Connection myConn = null;
		CallableStatement myStmt = null;
		
		
			try {
				myConn = DriverManager.getConnection(DB_URL, USER, PASS);
				
				
				// IN parameters				
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
				
				
				// INOUT Parameters
				myStmt = myConn.prepareCall("{call greet_the_department(?)}");
				myStmt.registerOutParameter(1,  Types.VARCHAR); // use this for INOUT
				myStmt.setString(1, theDepartment);
				
				System.out.println("\nCalling stored procedure.  greet_the_department('" + theDepartment + "')");
				myStmt.execute();
				System.out.println("Finished calling stored procedure");
				
				String theResult = myStmt.getString(1);
				
				System.out.println("\nThe result = " + theResult);
				
				
				// OUT Parameters
				myStmt = myConn.prepareCall("{call get_count_for_department(?, ?)}");
				myStmt.setString(1, theDepartment);
				myStmt.registerOutParameter(2, Types.INTEGER);
				
				System.out.println("\nCalling stored procedure.  get_count_for_department('" + theDepartment +"')" );
				myStmt.execute();
				System.out.println("Finished calling stored procedure");
				
				int theCount = myStmt.getInt(2);
				
				System.out.println("The count = " + theCount);
				
				
				// Procedure returning Resultset
				myStmt = myConn.prepareCall("{call get_employees_for_department(?)}");
				myStmt.setString(1, theDepartment);
				
				System.out.println("\nCalling stored procedure.  get_employees_for_department('" + theDepartment +"')" );
				myStmt.execute();
				System.out.println("Finished calling stored procedure");
				
				ResultSet myRs = myStmt.getResultSet();
				
				while(myRs.next()) {
					System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name") + ", " + myRs.getDouble("salary"));
				}
				
				
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
