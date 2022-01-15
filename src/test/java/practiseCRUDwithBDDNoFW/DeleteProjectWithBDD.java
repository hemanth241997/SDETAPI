package practiseCRUDwithBDDNoFW;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

//All the methods present in RestAssured is static
//multiple time we have to use class name. So importing it is better.
// .* will get all the methods in the class. Not specific to any particular methods

public class DeleteProjectWithBDD {
	
	@Test
	public void deleteProject()
	{
		when()
		.delete("http://localhost:8085/projects/TY_PROJ_001")
		
		.then()
		.assertThat()
		.statusCode(204)
		.log().all();
	}

}
