package responseValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StaticResponseValidation {

	@Test
	public void getAllProjectAndVerify() 
	{
		baseURI = "http://localhost:8085";
		String expCreatorName = "Chan";
		Response resp = when()
		.get("/projects");
		
		String actCreatorName = resp.jsonPath().get("[0].createdBy");
	
		resp.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.log().all();
		Assert.assertEquals(expCreatorName, actCreatorName);
		
		
		
	}
}
