package com.genericUtils;

/**
 * 
 * @author Chan
 *
 */
public interface EndPoints {

	String DATABASE_URL = "jdbc:mysql://localhost:3306/projects";
	String ADD_PROJECT="/addProject";
	String GET_ALLPROJECTS="/projects";
	String GETSINGLE_PROJECT="/projects/{projectId}";
	String UPDATE_PROJECT="/projects/{projectId}";
	String DELETE_PROJECT="/projects/{projectId}";
	
	String GET_EMPBYUSERNAME="/employee/{userName}";
	String GET_ALLEMP="/employees";
	String CREATEEMP="/employees";
	String GET_EMPBYEMPID="/employees/{empId}";
	String UPDATE_EMPPROJECT="/employees/{empId}";
	String DELETE_EMPPROJECT="/employees/{empIid}";
	
	
}
