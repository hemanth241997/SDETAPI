package practiseCRUDwithBDD;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class GetAllProjectwithDBDD {
	
	@Test
	public void getAllProjects()
	{
		when()
		.get("http://localhost:8085/projects")
		
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	}

}
