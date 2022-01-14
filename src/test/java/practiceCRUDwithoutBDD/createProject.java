package practiceCRUDwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class createProject {
	
	@Test
	public void createProject() {
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Prem");
		jobj.put("projectName", "Bank");
		jobj.put("status", "Created");
		jobj.put("teamSize", "30");
		
		RequestSpecification resp = RestAssured.given();
		resp.contentType(ContentType.JSON);
		resp.body(jobj);
		
		Response response = resp.post("http://localhost:8084/addProject");
		
		System.out.println(response.asPrettyString());
	
	
	}

}
