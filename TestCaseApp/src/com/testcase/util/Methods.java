/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.testcase.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nipuna
 */
public class Methods {
	 public String generateID(String prefix, String column, String tableName) {
	        String generatedId = "";

	        try {

	            Connection con = ConnectionManager.getConnection();
	            ResultSet rows;
	            Statement s = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

	            rows = s.executeQuery("SELECT * FROM " + tableName + " WHERE " + column + "=(SELECT MAX(" + column + ") FROM " + tableName + ")");//selectMax

	            int b = 0;

	            while (rows.next()) {

	                String id = rows.getString(column);
	                String a = id.substring(1);
	                b = Integer.parseInt(a);
	            }

	            if (b <= 8) {
	                b += 1;
	                generatedId += prefix + "000" + b;
	                return generatedId;
	            } else {
	                b += 1;
	                generatedId += prefix + "00" + b;
	                return generatedId;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return generatedId;
	    }
}
