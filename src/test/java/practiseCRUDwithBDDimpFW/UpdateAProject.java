package practiseCRUDwithBDDimpFW;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.genericUtils.BaseApiClass;
import com.genericUtils.EndPoints;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateAProject extends BaseApiClass{

	@Test
	public void getandDelete()
	{
		
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "prem");
		jObj.put("projectName", "SDET26");
		jObj.put("status", "Created");
		jObj.put("teamSize", 10);
		given()
		.contentType(ContentType.JSON)
		.pathParam("projectId", "TY_PROJ_2602")
		
		.body(jObj)
		.when()
		.put(EndPoints.UPDATE_PROJECT)
		
		.then().assertThat().log().all();
	}
}
