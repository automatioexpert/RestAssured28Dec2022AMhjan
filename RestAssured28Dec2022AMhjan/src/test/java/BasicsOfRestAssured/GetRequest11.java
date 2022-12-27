package BasicsOfRestAssured;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;




public class GetRequest11 {
	
	
	@Test
	public void restAssuredGet()
	{
		RestAssured
		  .get("https://restful-booker.herokuapp.com/booking/10")
		  .then()
		  .statusCode(200)
		  .statusLine("HTTP/1.1 200 OK")
		  .body("firstname", Matchers.equalTo("Mary"))
		  .body("bookingdates.checkin", Matchers.equalTo("2015-09-14"));
		
	}

}
