package postRequestWays;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class CreateProjectUsingHashMap {

	
	@Test
	public void createProjectUsingHashMap()
	{
		baseURI = "http://localhost";
		port = 8085;
		
		//design pattern in REstAssured. WHere Baseuri and port will get appended with the URI. Whatever written in base uri will be appended. 
		
		
		HashMap map = new HashMap();
		map.put("createdBy", "sapan");
		map.put("projectName", "SDET26");
		map.put("status", "Created");
		map.put("teamSize", 10);
		
		given()
		.contentType(ContentType.JSON)
		.body(map)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
		
	
	}
}
