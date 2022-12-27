package BasicsOfRestAssured;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;




public class GetRequest12 {
	
	
	@Test
	public void restAssuredGet()
	{
		
		
		RestAssured
		.given()
			
		.when()
		  .get("https://restful-booker.herokuapp.com/booking/10")
		
		.then()
		  .statusCode(200);
		
		
		
		
		
		
	}

}
