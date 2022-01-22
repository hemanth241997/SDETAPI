package responseValidation;

import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class DynamicResponseValidation {
	
	@Test
	public void dynamicValidation()
	{
		String expectedProName = "Chan";
		Response resp = when()
		.get("http://localhost:8084/projects");
		
		List<String> proName = resp.jsonPath().get("createdBy");
		
		boolean flag = false;
		for (String ele : proName) {
			
			if(ele.equals(expectedProName))
			{
				flag = true;
				break;
			}
			
		}
		resp.then().assertThat()
		.log().all();
		Assert.assertEquals(flag, true);
		
	}

}
