package parametersAndAuthentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameter {
	
	@Test
	public void pathParameter()
	{
		given()
		.pathParam("projectId", "TY_PROJ_257")
		
		.when()
		.delete("http://localhost:8085/projects/{projectId}")
		
		.then()
		.assertThat()
		.statusCode(204)
		.log().all();
		
		
		
	}

}
