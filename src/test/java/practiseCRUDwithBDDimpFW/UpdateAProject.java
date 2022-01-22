package practiseCRUDwithBDDimpFW;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.genericUtils.BaseApiClass;
import com.genericUtils.EndPoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateAProject extends BaseApiClass{

	@Test
	public void getandDelete()
	{
		
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "prem");
		jObj.put("projectName", "SDET26");
		jObj.put("status", "Created");
		jObj.put("teamSize", 10);
		Response resp = given()
		.contentType(ContentType.JSON)
		.pathParam("projectId", "TY_PROJ_2602")
		
		.body(jObj)
		.when()
		.put(EndPoints.UPDATE_PROJECT);
		
		resp.then().assertThat().log().all();
		String respProName = resp.jsonPath().get("projectName");
		
		Assert.assertEquals(respProName, "prem");
	}
}
