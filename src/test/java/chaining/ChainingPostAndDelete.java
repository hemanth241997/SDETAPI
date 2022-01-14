package chaining;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ChainingPostAndDelete {
	
	@Test
	public void postAndDelete()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Pavan");
		jobj.put("projectName", "Pallavi");
		jobj.put("status", "On Going");
		jobj.put("teamSize", 10);
		
		Response resp = given()
			.contentType(ContentType.JSON)
			.body(jobj)
			
		.when()
			.post("http://localhost:8085/addProject");
			String proId = resp.jsonPath().get("projectId");
		resp.then().assertThat().statusCode(201);
		resp.prettyPrint();
			
			System.out.println(proId);
			
		given()
			.pathParam("projectId", proId)
		
		.when()
			.delete("http://localhost:8085/projects/{projectId}")
			
		.then()
			.assertThat()
			.statusCode(204)
			.log().all();
		
	}

}
