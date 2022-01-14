package com.genericUtils;

import io.restassured.response.Response;

public class JsonUtility {
	
	public String getJsonValueData(Response response, String jsonPath)
	{
		String jsonData = response.jsonPath().get(jsonPath);
		return jsonData;
	}

}


