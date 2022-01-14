package parametersAndAuthentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BasicAuth {

	
	@Test
	public void basicAuth()
	{
		given()
		.auth().basic("rmgyantra", "rmgy@9999")
		
		.when()
		.get("http://localhost:8085/login")
		
		.then()
		.assertThat()
		.statusCode(202)
		.log().all();
	}
}
