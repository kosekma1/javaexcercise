package com.martin.advanced.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCResultSetMetadata {
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/demo?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Prague";
	
	static final String USER = "student";
	static final String PASS = "student";
				
	public static void main(String[] args) {
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			// 2. Run query
			myStmt = myConn.createStatement();
			String sql = "SELECT id, last_name, first_name, salary FROM employees";
			myRs = myStmt.executeQuery(sql);
			
			// 3. Get result set metadata
			ResultSetMetaData rsMetaData = myRs.getMetaData();
			
			// 5. Display info
			int columnCount = rsMetaData.getColumnCount();
			System.out.println("Column count: " + columnCount + "\n");
			
			for(int column=1; column <= columnCount; column++) {
				System.out.println("\nColumn name: " + rsMetaData.getColumnName(column));
				System.out.println("Column type name: " + rsMetaData.getColumnTypeName(column));
				System.out.println("Is Nullable: " + rsMetaData.isNullable(column));
				System.out.println("Is Auto Increment: " + rsMetaData.isAutoIncrement(column));
			}
														
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
