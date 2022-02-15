package testScriptsRMGYantra;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadExecutionException;

import com.genericUtils.BaseApiClass;
import com.genericUtils.EndPoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import sdet26POJOClass.ProjectLibrary;

import static io.restassured.RestAssured.*;

public class CRUD extends BaseApiClass{
	
	@Test
	public void crud() throws Throwable
	{
	/**
	 * Create
	 */
		String expProName = "Amazon";
		ProjectLibrary pLib = new ProjectLibrary("Hemanth", expProName, "Ongoing", 2);
		
		Response resp = given()
			.contentType(ContentType.JSON)
			.body(pLib)
			
		.when()
			.post(EndPoints.ADD_PROJECT);
		String respActProName = jsonUtil.getJsonValueData(resp, "projectName");
		resp.then()
		.assertThat().contentType(ContentType.JSON)
			.statusCode(201)
			.log().all();
		String projId = resp.jsonPath().get("projectId");
		
		String query = "select * from project;";
		String dbActProName = dbUtil.getAndVerifyTheData(query,4, expProName);
		Assert.assertEquals(respActProName, expProName);
		Assert.assertEquals(dbActProName, expProName);
		
		
	/**
	 * Update
	 */
		
		ProjectLibrary pLib2 = new ProjectLibrary("Hemanth", expProName, "Completed", 5);

		
		given()
		.pathParam("projectId", projId)
		.contentType(ContentType.JSON)
		.body(pLib2)
		.when()
		.put(EndPoints.UPDATE_PROJECT)
		
		.then()
		.log().all();
		
	/**
	 * Read
	 */
		given()
		.pathParam("projectId", projId)
		.when()
		.get(EndPoints.GETSINGLE_PROJECT)
		.then().log().all();
		
	/**
	 * Delete
	 */
		given()
		.pathParam("projectId", projId)
		
		.when()
		.delete(EndPoints.DELETE_PROJECT)
		.then().log().all();
		
	}

}
