package parametersAndAuthentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameter2 {
	
	@Test
	public void queryParam()
	{
		given()
		.pathParam("username", "chan-prem")
		.queryParam("sort", "created")
		//actual one(https://api.github.com/users/chan-prem/repos?sort=created)
		
		.when()
		.get("https://api.github.com/users/{username}/repos")
		
		.then()
		.log().all();
		
	}

}
