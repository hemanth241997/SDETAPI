package practiceCRUDwithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProject {

	@Test
	public void getSingleProject()
	{
		Response res = RestAssured.get("http://localhost:8085/projects/");
		System.out.println(res.asString());
		System.out.println(res.prettyPrint());
		System.out.println(res.prettyPeek());
	}
}
