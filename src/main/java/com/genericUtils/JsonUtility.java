package com.genericUtils;

import io.restassured.response.Response;
/**
 * This method will be used to get the data present in response
 * @author Chan
 *
 */
public class JsonUtility {
	
	public String getJsonValueData(Response response, String jsonPath)
	{
		String jsonData = response.jsonPath().get(jsonPath);
		return jsonData;
	}

}


