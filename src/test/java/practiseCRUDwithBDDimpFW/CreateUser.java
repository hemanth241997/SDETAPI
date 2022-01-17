package practiseCRUDwithBDDimpFW;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.genericUtils.BaseApiClass;
import com.genericUtils.EndPoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import sdet26POJOClass.UserLibrary;

public class CreateUser extends BaseApiClass{
	
	@Test
	public void createUser()
	{
		UserLibrary uLib = new UserLibrary("SDET", "25/05/1999", "nithesh@gmail.com", "nithssesh", 15, "9888777657", "hdc", "ROLE_ADMIN", "nithssesh");
		
		Response resp = given()
			.contentType(ContentType.JSON)
			.body(uLib)
			
			
		.when()
			.post(EndPoints.CREATEEMP);
			
		resp.then()
			.assertThat()
			.statusCode(201)
			.log().all();
		
	}

}
