package postRequestWays;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import sdet26POJOClass.ProjectLibrary;

public class CreateProjectUsingPOJO {
	
	
	@Test
	public void createProjectUsingPOJO()
	{
		baseURI = "http://localhost";
		port = 8085;
		
		ProjectLibrary pLib = new ProjectLibrary("Mrudula", "Logical", "COmpleted", 10);
		
		given()
		.contentType(ContentType.JSON)
		.body(pLib)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
	}

}
