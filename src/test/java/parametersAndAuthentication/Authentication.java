package parametersAndAuthentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Authentication {

/*
 *Preemptive Auth==> eventhough if server doesn't ask fr credentials
 *rest provides the credentials to server.
 * 
 *
 *DIgestive Auth==> Rest will provide the credentails only when the server asks for it.
 *
 *Digestive is more secured than Preemptive
 *It will be encrypted mode
 *
 */

	@Test
	public void preemptiveAuth()
	{
		given()
			.auth().preemptive().basic("rmgyantra", "rmgy@9999")
			
		.when()
			.get("http://localhost:8084/login")
			
		.then()
			.log().all();
		
	}
		
	@Test
	public void digestiveAuth() 
	{
		given()
			.auth().digest("rmgyantra", "rmgy@999")
			
		.when()
			.get("http://localhost:8084/login")
		
		.then().log().all();
	}
	
}
