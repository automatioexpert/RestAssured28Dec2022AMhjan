package BasicsOfRestAssured;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetRequest6 {
	
	
	@Test
	public void restAssuredGet()
	{
		JsonPath jsonPath = RestAssured
		  .get("https://restful-booker.herokuapp.com/booking/10")
		  .then()
		  .statusCode(200)
		  .statusLine("HTTP/1.1 200 OK")
		 // .body("firstname", Matchers.equalTo("Mary"))
		 // .body("bookingdates.checkin", Matchers.equalTo("2015-09-14"))
		  .extract()
		  .jsonPath();
		  
		
		System.out.println(jsonPath.getString("firstname"));
		System.out.println(jsonPath.getString("bookingdates.checkout"));
		
		
	}

}
