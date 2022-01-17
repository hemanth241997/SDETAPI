package practiseCRUDwithBDDimpFW;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.genericUtils.BaseApiClass;
import com.genericUtils.EndPoints;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Creat extends BaseApiClass{
	
	@Test
	public void create()
	{

			String expectedProjectName = "Jio";
			JSONObject pObj = new JSONObject();
			pObj.put("createdBy", "Sai");
			pObj.put("projectName", expectedProjectName);
			pObj.put("status", "Completed");
			pObj.put("teamSize", 12);
			
			Response projectResp = given()
				.contentType(ContentType.JSON)
				.body(pObj)
			.when()
				.post(EndPoints.ADD_PROJECT);
			
			String projName = projectResp.jsonPath().get("projectName");
			
			// employee Data
			String expectedUserName = "Sai";
			JSONObject eObj = new JSONObject();

			eObj.put("designation", "SDET26");
			eObj.put("dob", "dd/MM/yyyy");
			eObj.put("email", "tyss@gmail.com");
			eObj.put("empName", "Sundar");
			eObj.put("experience", 14);
			eObj.put("mobileNo", "1234567890");
			eObj.put("project", projName);
			eObj.put("role", "ROLE_EMPLOYEE");
			eObj.put("username", expectedUserName);
			
			Response empResp = given()
				.contentType(ContentType.JSON)
				.body(eObj)

				.when()
					.post(EndPoints.CREATEEMP);
			
			String actualUserName = empResp.jsonPath().get("username");
			String actualProjectName = empResp.jsonPath().get("project");
			
			empResp.then()
				.assertThat()
				.statusCode(201)
				.log().all();
			
			long timeTaken = empResp.getTime();
			System.out.println(timeTaken);
			
			
			// validation 
			Assert.assertEquals(expectedUserName, actualUserName);
			Assert.assertTrue(timeTaken < 600);
			Assert.assertEquals(expectedProjectName, projName);

		}
	}


