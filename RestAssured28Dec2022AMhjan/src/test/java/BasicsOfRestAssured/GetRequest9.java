package BasicsOfRestAssured;

import java.util.Arrays;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;




public class GetRequest9 {
	
	
	@Test
	public void restAssuredGet()
	{
		RestAssured
		  .get("https://restful-booker.herokuapp.com/booking/10")
		  .then()
		  .statusCode(Matchers.in(Arrays.asList(200,201)))
		  .body("firstname", Matchers.notNullValue());
		
	}

}
