package com.martin.advanced.database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class JDBCTransactions {
	
static final String DB_URL = "jdbc:mysql://localhost:3306/demo?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Prague";
	
	static final String USER = "student";
	static final String PASS = "student";

	public static void main(String[] args) {
		Connection myConn = null;
		CallableStatement myStmt = null;
		
		
			try {
				myConn = DriverManager.getConnection(DB_URL, USER, PASS);
				
				
				
				ResultSet myRs = myStmt.getResultSet();
				
				while(myRs.next()) {
					System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name") + ", " + myRs.getDouble("salary"));
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
		


}
