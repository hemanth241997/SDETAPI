package chaining;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ChainingDelete {

	@Test
	public void chaining()
	{
		
	Response resp =	when()
		.get("http://localhost:8085/projects");
		
	String proId = resp.jsonPath().get("[6].projectId");

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
