package com.testcase.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.testcase.dao.ProjectDAO;
import com.testcase.dao.ProjectDAOImpl;
import com.testcase.model.Project;
import com.testcase.util.Methods;

@WebServlet(name="projectCon",urlPatterns="/projectCon")
public class ProjectController extends HttpServlet{
	public ProjectController() {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action=req.getParameter("action");
		if(action.equalsIgnoreCase("project_list")){
			List<Project> list=new ArrayList<Project>();
			ProjectDAO dao=new ProjectDAOImpl();
			list=dao.getAllData();
			PrintWriter out=resp.getWriter();
			
			 resp.setContentType("application/json");
             resp.setCharacterEncoding("UTF-8");        
             out.write(new Gson().toJson(list));
             out.flush();
             out.close();
		}
		
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("project_name");
		
		Methods method=new Methods();
		String id=method.generateID("P", "id", "project");// generate new id
		
		Project model=new Project();
		model.setId(id);
		model.setProjectname(name);
		
		ProjectDAO dao=new ProjectDAOImpl();
		boolean result=dao.save(model);
		
		PrintWriter out=resp.getWriter();
		out.print(result);
		out.flush();
	}
	
}
