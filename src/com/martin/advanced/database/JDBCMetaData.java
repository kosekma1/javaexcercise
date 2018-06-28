package com.martin.advanced.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCMetaData {
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/demo?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Prague";
	
	static final String USER = "student";
	static final String PASS = "student";
	
	public static void main(String[] args) {
	
		String catalog = "demo";
		String schemaPattern = null;
		String tableNamePattern = null;
		String[] types = null;
				
		Connection myConn = null;
		ResultSet myRs = null;
				
		try {
			myConn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			DatabaseMetaData databaseMetaData = myConn.getMetaData();
			
			System.out.println("Poduct name: " + databaseMetaData.getDatabaseProductName());
			System.out.println("Poduct version: " + databaseMetaData.getDatabaseProductVersion());
			System.out.println();
			
			System.out.println("JDBC Driver name: " + databaseMetaData.getDriverName());
			System.out.println("JDBC Driver version: " + databaseMetaData.getDriverVersion());
			
			
			System.out.println("\nList of Tables");
			System.out.println("--------------");
			
			myRs = databaseMetaData.getTables(catalog, schemaPattern, tableNamePattern, types);
								
			while(myRs.next()) {
				System.out.println(myRs.getString("TABLE_NAME"));
			}
			
			System.out.println("\nList of Columns");
			System.out.println("--------------");
			
			String columnNamePattern = null;
			
			myRs = databaseMetaData.getColumns(catalog, schemaPattern, "employees", columnNamePattern);
					
			
			while(myRs.next()) {
				System.out.println(myRs.getString("COLUMN_NAME"));
			}
								
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				myConn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}										
				
	}
	
	private static void close(Connection myConn, ResultSet myRs) {
		
	}

}
