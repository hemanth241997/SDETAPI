package practiseCRUDwithBDDNoFW;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProjectWithBDD {
	
	@Test
	public void updateProject()
	{
		JSONObject jobj  = new JSONObject();
		jobj.put("createdBy", "Pavan");
		jobj.put("projectName", "SDET25");
		jobj.put("status", "completed");
		jobj.put("teamSize", 12);
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		
		.when()
		.put("http://localhost:8085/projects/TY_PROJ_001")
		
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
		
	}

}
