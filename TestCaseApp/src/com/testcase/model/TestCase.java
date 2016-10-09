package com.testcase.model;

public class TestCase {
private String id,testsuite_id,project_id,description;
private int status;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getTestsuite_id() {
	return testsuite_id;
}
public void setTestsuite_id(String testsuite_id) {
	this.testsuite_id = testsuite_id;
}
public String getProject_id() {
	return project_id;
}
public void setProject_id(String project_id) {
	this.project_id = project_id;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}

}
