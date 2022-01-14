package postRequestWays;

import java.io.File;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class CreateProjectUsingJSONFIle {
	
	@Test
	public void createProject()
	{
		baseURI = "http://localhost";
		port = 8085;
		
		
		File file = new File("./data.json");
		given()
		.contentType(ContentType.JSON)
		.body(file)
		
		.when()
		.post("./addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
		
	}

}
