package parametersAndAuthentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class OAuthAuthentication {

	@Test
	public void oauthAuthentication()
	{
		Response resp = given()
			.formParam("client_id", "SDETAPP")
			.formParam("client_secret", "bf0b801b566345d8e78bcfa4cf1ee814")
			.formParam("grant_type", "client_credentials")
			.formParam("redirect_uri", "https://example.com")
			
		.when()
			.post("http://coop.apps.symfonycasts.com/token");
		
			String token = resp.jsonPath().get("access_token");
		
		given()
			.auth()
			.oauth2(token)
			.pathParam("USER_ID", "2682")
			
		.when()
			.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
			
		.then()
			.log().all();
				
		
		
	}
}


/*coopAPI - Register
 * 
 * 
 */
