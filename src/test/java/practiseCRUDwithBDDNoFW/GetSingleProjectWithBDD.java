package practiseCRUDwithBDDNoFW;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetSingleProjectWithBDD {

	@Test
	public void getSingleProject()
	{
		when()
		.get("http://localhost:8085/projects/TY_PROJ_001")
		
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	}
}
