package com.testcase.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.testcase.model.TestCase;
import com.testcase.util.ConnectionManager;

public class TestCaseDAOImple implements TestCaseDAO {

	@Override
	public boolean save(TestCase model) {
		boolean result=false;
		 PreparedStatement pst=null;
	       Connection connection = ConnectionManager.getConnection();
	        
	        try {
	            
	            String sql = "INSERT INTO testcase (id,testsuite_id,project_id,description,status) values ( ?, ?, ?,?,?)";

	            pst = connection.prepareStatement(sql);

	            pst.setString(1, model.getId());
	            pst.setString(2, model.getTestsuite_id());
	            pst.setString(3, model.getProject_id());
	            pst.setString(4, model.getDescription());
	            pst.setInt(5, 1);

	            int res = pst.executeUpdate();
	            if (res > 0) {
	                System.out.println("Data Added to : testcase");
	                result=true;
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally {
	            if (connection != null) { // close the connection 
	                try {
	                    connection.close();
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	                connection = null;
	            }

	            if (pst != null) {// close prepareStatement
	                try {
	                    pst.close();
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	                pst = null;
	            }
	        }
		return result;
	}

}
