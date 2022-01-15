package practiseCRUDwithBDDNoFW;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class CreateProjectWithBDD {
	
	@Test
	public void createProject()
	{
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Pavan");
		jobj.put("projectName", "SDET26");
		jobj.put("status", "Created");
		jobj.put("teamSize", 10);
		
		//precondition
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		
		//Action
		.when()
		.post("http://localhost:8085/addProject")
		
		//validation
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
		
	}

	
}
