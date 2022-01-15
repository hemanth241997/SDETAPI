package practiseCRUDwithBDDimpFW;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.genericUtils.BaseApiClass;
import com.genericUtils.EndPoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import sdet26POJOClass.ProjectLibrary;

public class AddSingleProjectwithCreatedStatus extends BaseApiClass{
	
	@Test
	public void addSingleProject() throws Throwable
	{
		String expProName = "hiadscssdfgdaa";
		ProjectLibrary pLib = new ProjectLibrary("deepak", expProName, "Created", 10);
		
		Response resp = given()
			.contentType(ContentType.JSON)
			.body(pLib)
			
		.when()
			.post(EndPoints.ADD_PROJECT);
		String respActProName = jsonUtil.getJsonValueData(resp, "projectName");
			System.out.println(respActProName+"print this");
		resp.then()
		.assertThat().contentType(ContentType.JSON)
			.statusCode(201)
			.log().all();
		
		String query = "select * from project;";
		String dbActProName = dbUtil.getAndVerifyTheData(query,4, expProName);
		Assert.assertEquals(respActProName, expProName);
		Assert.assertEquals(dbActProName, expProName);
		
		
	}

}
