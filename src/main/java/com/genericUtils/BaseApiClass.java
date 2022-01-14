package com.genericUtils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BaseApiClass {
	public DataBaseUtility dbUtil = new DataBaseUtility();
	public JavaUtility jUtil= new JavaUtility();
	public JsonUtility jsonUtil = new JsonUtility();
	
	@BeforeSuite
	public void BS() throws Throwable
	{
		dbUtil.connectDB();
		System.out.println("DB connected");

		baseURI = "http://localhost";
		port = 8085;
		
	}
	
	@AfterSuite
	public void AS()
	{
		dbUtil.closeDB();
		System.out.println("DB Closed");
		
	}
}
