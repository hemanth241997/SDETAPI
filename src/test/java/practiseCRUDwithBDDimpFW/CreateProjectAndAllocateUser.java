package practiseCRUDwithBDDimpFW;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.genericUtils.BaseApiClass;
import com.genericUtils.DataBaseUtility;
import com.genericUtils.EndPoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import sdet26POJOClass.ProjectLibrary;
import sdet26POJOClass.UserLibrary;

import static io.restassured.RestAssured.*;

public class CreateProjectAndAllocateUser extends BaseApiClass{
	
	
	@Test
	public void createAndAllocateUser() throws Throwable
	{

		ProjectLibrary pObj = new ProjectLibrary("deepak", "Airtel", "Completed", 12);
		Response resp = given()
			.contentType(ContentType.JSON)
			.body(pObj)
			
		.when()
			.post(EndPoints.ADD_PROJECT);
		resp.prettyPrint();
		String respActProName = resp.jsonPath().get("projectName");
		String expUserName = "nithesh";
		UserLibrary uLib = new UserLibrary("SDET", "25/05/1999", "nithesh@gmail.com", "nithesh", 15, "9888777657", respActProName, "ROLE_ADMIN", expUserName);
		given()
			.contentType(ContentType.JSON)
			.body(uLib)
			
			
		.when()
			.post(EndPoints.CREATEEMP).prettyPrint();
		String 
		String query = "select * from employee;";
			String dbUserName = dbUtil.getAndVerifyTheData(query, 11, expUserName);
			Assert.assertEquals(res, expUserName);
			Assert.assertEquals(expUserName, dbUserName);
			
			
	}

}
