package com.testcase.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.testcase.model.Project;
import com.testcase.util.ConnectionManager;

public class ProjectDAOImpl implements ProjectDAO {

	@Override
	public boolean save(Project model) {
		boolean result=false;
		 PreparedStatement pst=null;
	       Connection connection = ConnectionManager.getConnection();
	        
	        try {
	            
	            String sql = "INSERT INTO project (id,projectname,status) values ( ?, ?, ?)";

	            pst = connection.prepareStatement(sql);

	            pst.setString(1, model.getId());
	            pst.setString(2, model.getProjectname());
	            pst.setInt(3, 1);

	            int res = pst.executeUpdate();
	            if (res > 0) {
	                System.out.println("Data Added to : project");
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

    public List<Project> getAllData() {
        // TODO Auto-generated method stub
        PreparedStatement pst=null;
       Connection connection = ConnectionManager.getConnection();
        List<Project> EntityList = new ArrayList<Project>();

        try {

            String sql = "SELECT * FROM project WHERE status=1 ";

            pst = connection.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
            	Project Entity = new Project();
                Entity.setId(rs.getString(1));
                Entity.setProjectname(rs.getString(2));
                EntityList.add(Entity);
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

        return EntityList;
    }

}
