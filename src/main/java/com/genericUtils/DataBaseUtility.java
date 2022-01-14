package com.genericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	
	/**
	 * This method will establish connection to database
	 */
	
	Connection connection = null;
	public void connectDB() throws Throwable
	{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection(EndPoints.DATABASE_URL,"root","root");
		
	}
  
	/**
	 * this method will close the database Connection 
	 */
	public void closeDB()
	{
		try {
			connection.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
			
	}
	/**
	 * this method will return the data from DB
	 * @param query
	 * @return
	 */
	
	public ResultSet getAllData(String query)
	{
		ResultSet result = null;
		try {
			result = connection.createStatement().executeQuery(query);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
		
	}

/**
 * This method will match the column data based on the expectedData
 * @param query
 * @param columnNumber
 * @param expectedData
 * @return
 * @throws Throwable 
 */

	public String getAndVerifyTheData(String query, int columnNumber, String expectedData) throws Throwable
	{
		ResultSet result = connection.createStatement().executeQuery(query);
		String actualData = null;
		boolean flag = false;
		try {

			while(result.next())
			{
				String dbData = result.getString(columnNumber);
						if(dbData.equals(expectedData))
						{
							actualData=dbData;
							flag = true;
							break;
						}
			}
				
		}catch(Exception e) {
			
		}
		if(flag)
		{
			System.out.println("Data is present and verified");
			return actualData;
		}else {
			System.out.println("Data is not present in databse");
			return actualData;

		}
		
	}
}
	
