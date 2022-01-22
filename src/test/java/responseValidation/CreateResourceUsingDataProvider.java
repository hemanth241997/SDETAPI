package responseValidation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import sdet26POJOClass.ProjectLibrary;

public class CreateResourceUsingDataProvider {

	@Test(dataProvider = "getData")
	public void createResource(String createdBy, String projectName, String status, int teamSize)
	{
		ProjectLibrary pLib = new ProjectLibrary(createdBy, projectName, status, teamSize);
		given()
		.contentType(ContentType.JSON)
		.body(pLib)
		
		.when()
		.post("http://localhost:8085/addProject")
		
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(201)
		.log().all();
		
	}
		@DataProvider
		public Object[][] getData()
		{
			Object [][] obj = new Object[2][4];
			obj[0][0] = "MeCreator";
			obj[0][1] = "MineName";
			obj[0][2] = "Completed";
			obj[0][3] = 10;
			
			obj[1][0] = "YouCreator";
			obj[1][1] = "YourName";
			obj[1][2] = "Completed";
			obj[1][3] = 10;
			return obj;
			
			
			
			
		}
		
		
		
	}


