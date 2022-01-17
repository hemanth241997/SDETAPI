package practiseCRUDwithBDDimpFW;

import org.testng.annotations.Test;

import com.genericUtils.BaseApiClass;
import com.genericUtils.EndPoints;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import sdet26POJOClass.ProjectLibrary;
import sdet26POJOClass.UserLibrary;

public class CreateUserAndDelete extends BaseApiClass 
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
			String employeeId = resp.jsonPath().get("employeeId");
			resp.prettyPrint();
		
			
			given().pathParam("empId", employeeId)
			
			.when()
			.delete(EndPoints.GET_EMPBYEMPID)
			
			.then()
			.assertThat().contentType(ContentType.JSON)
			.statusCode(204)
			.log().all();
		}

}

