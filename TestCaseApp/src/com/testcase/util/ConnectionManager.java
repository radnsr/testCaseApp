/* 
 * All Right Reseve to the Asia Tours & Events.
 * Open this element in Netbeans 7.4.
 */

package com.testcase.util;

import java.sql.*;


/**
 *
 * @author Nipuna
 * This class includes the database connection method
 */
public class ConnectionManager {
    static Connection conn = null;
    static String url = null;
    
     public static Connection getConnection() { 
		try {
			String url = "jdbc:mysql://localhost:3306/" + "testcase";
			// assuming "QuotationSystem" is your DataSource name
			Class.forName("com.mysql.jdbc.Driver");
			try {
				conn = DriverManager.getConnection(url, "root", "Don@12345");
				// assuming your SQL Server's username is "root"
				// and password is "root123"
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
