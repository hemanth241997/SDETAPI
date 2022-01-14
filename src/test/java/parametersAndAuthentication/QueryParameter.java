package parametersAndAuthentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameter {
	
	@Test
	public void queryParam()
	{
		given()
		.queryParam("page", "2")
		//actual one(https://reqres.in//api//users?page=2)
		
		.when()
		.get("https://reqres.in//api//users")
		
		.then()
		.log().all();
		
	}

}
