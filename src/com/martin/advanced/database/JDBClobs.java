package com.martin.advanced.database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * For user CLOBS in database has to be column of type LONGTEXT in particular table.
 * CLOB is a huge number of characters for example XML file etc.
 * CBLOBS are not supported in all databases.
 * 
 * alter table employees add resume2 LONGTEXT
 * 
 * @author Martin, www.love2code.com
 *
 */

public class JDBClobs {

	static final String DB_URL = "jdbc:mysql://localhost:3306/demo?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Prague";

	static final String USER = "student";
	static final String PASS = "student";

	public static void main(String[] args) {

		Connection myConn = null;
		ResultSet myRs = null;

		try {
			// 1. Get connection to database
			myConn = DriverManager.getConnection(DB_URL, USER, PASS);

			// 2. Prepare statement for WRITE CLOB to database
			String sql = "UPDATE employees set resume2=? WHERE email='mary.public@foo.com'";
			PreparedStatement myStmt = myConn.prepareStatement(sql);

			// 3. Set parameter for resume file name
			File theFile = new File("sample_resume.txt");
			FileReader input = new FileReader(theFile);
			myStmt.setCharacterStream(1, input);

			System.out.println("Reading input file: " + theFile.getAbsolutePath());

			// Execute statement
			System.out.println("\nStoring resume2 in database: " + theFile);
			System.out.println(sql);

			myStmt.executeUpdate();

			System.out.println("\nCompleted successfully!");

			// 1. Prepare statement for READ CLOB from database
			Statement stmt = myConn.createStatement();
			sql = "SELECT resume2 FROM employees WHERE email='mary.public@foo.com'";

			myRs = stmt.executeQuery(sql);

			theFile = new File("resume_from_db.txt");
			FileWriter output = new FileWriter(theFile);

			if (myRs.next()) {

				Reader inputReader = myRs.getCharacterStream("resume2");
				
				int theChar;
				
				try {
					while ((theChar=inputReader.read()) > 0) {
						output.write(theChar);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println("\nSaved to file: " + theFile.getAbsolutePath());
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
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
