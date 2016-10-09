package com.testcase.dao;

import java.util.List;

import com.testcase.model.Project;

public interface ProjectDAO {
	public boolean save(Project model);
	public List<Project> getAllData();
}
