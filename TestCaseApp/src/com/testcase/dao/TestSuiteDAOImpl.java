package com.testcase.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.testcase.model.TestSuite;
import com.testcase.util.ConnectionManager;

public class TestSuiteDAOImpl implements TestSuiteDAO {

	@Override
	public boolean save(TestSuite model) {
		boolean result=false;
		 PreparedStatement pst=null;
	       Connection connection = ConnectionManager.getConnection();
	        
	        try {
	            
	            String sql = "INSERT INTO testsuite (id,project_id,description,status) values ( ?, ?, ?,?)";

	            pst = connection.prepareStatement(sql);

	            pst.setString(1, model.getId());
	            pst.setString(2, model.getProject_id());
	            pst.setString(3, model.getDescription());
	            pst.setInt(4, 1);

	            int res = pst.executeUpdate();
	            if (res > 0) {
	                System.out.println("Data Added to : testsuite");
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
