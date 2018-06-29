package com.martin.advanced.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCBlobs {

	static final String DB_URL = "jdbc:mysql://localhost:3306/demo?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Prague";

	static final String USER = "root";
	static final String PASS = "";

	public static void main(String[] args) {

		Connection myConn = null;
		ResultSet myRs = null;

		try {
			// Get connection to database
			myConn = DriverManager.getConnection(DB_URL, USER, PASS);

			// Prepare statement for write to database
			String sql = "UPDATE employees set resume=? WHERE email='mary.public@foo.com'";
			PreparedStatement myStmt = myConn.prepareStatement(sql);

			// Set parameter for resume file name
			File theFile = new File("sample_resume.pdf");
			FileInputStream input = new FileInputStream(theFile);
			myStmt.setBinaryStream(1, input);

			System.out.println("Reading input file: " + theFile.getAbsolutePath());

			// Execute statement
			System.out.println("\nStoring resume in database: " + theFile);
			System.out.println(sql);

			myStmt.executeUpdate();

			System.out.println("\nCompleted successfully!");

			// Prepare statement for read from database
			Statement stmt = myConn.createStatement();
			sql = "SELECT resume FROM employees WHERE email='mary.public@foo.com'";

			myRs = stmt.executeQuery(sql);

			theFile = new File("resume_from_db.pdf");
			FileOutputStream output = new FileOutputStream(theFile);

			if (myRs.next()) {

				InputStream inputStream = myRs.getBinaryStream("resume");

				byte[] buffer = new byte[1024];
				try {
					while (inputStream.read(buffer) > 0) {
						output.write(buffer);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println("\nSaved to file:" + theFile.getAbsolutePath());
			System.out.println("\nCompleted successfully!");
			

			try {
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
