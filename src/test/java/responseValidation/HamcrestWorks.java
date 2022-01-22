package responseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class HamcrestWorks {
	
	@Test
	public void testing()
	{

		when()
			.get("http://localhost:8084/projects")
	
		.then()
			.assertThat()
			.statusCode(201)
			.assertThat().time(Matchers.lessThan(600l),TimeUnit.MILLISECONDS)
			.assertThat().body("[0].projectName",Matchers.equalTo("Arjuna"))
			.log().all();
	
	
	}
}
