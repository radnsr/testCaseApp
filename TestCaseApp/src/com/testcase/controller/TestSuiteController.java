package com.testcase.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testcase.dao.ProjectDAO;
import com.testcase.dao.ProjectDAOImpl;
import com.testcase.model.Project;
import com.testcase.util.Methods;

@WebServlet(name="testSuiteCon",urlPatterns="/testSuiteCon")
public class TestSuiteController extends HttpServlet{
	public TestSuiteController() {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
