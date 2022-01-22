package practiseCRUDwithBDDimpFW;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.genericUtils.BaseApiClass;
import com.genericUtils.EndPoints;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import sdet26POJOClass.UserLibrary;

public class CreateUserAndGet extends BaseApiClass 
{
		
		@Test
		public void createProject() 
		{
			UserLibrary uLib = new UserLibrary("SDET", "25/05/1999", "paven@gmail.com", "nithesh", 15, "9888777657", "pavan", "ROLE_ADMIN", "pavan");
			Response resp = given()
					.contentType(ContentType.JSON)
					.body(uLib)
			.when()
					.post(EndPoints.CREATEEMP);
				resp.then().statusCode(201);
				String emplId = resp.jsonPath().get("employeeId");
				System.out.println(emplId);
			
			
			given().pathParam("empId", emplId)
			
			.when()
			.get(EndPoints.GET_EMPBYEMPID)
			
			.then()
			.assertThat().contentType(ContentType.JSON)
			.statusCode(200)
			.log().all();
			
		}

}

