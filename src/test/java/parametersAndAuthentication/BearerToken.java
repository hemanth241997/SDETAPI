package parametersAndAuthentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerToken {

	@Test
	public void token()
	{
		given()
		.auth().oauth2("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")
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
		
		
		
	}
}
