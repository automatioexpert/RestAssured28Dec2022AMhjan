package BasicsOfRestAssured;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;




public class GetRequest3 {
	
	
	@Test
	public void restAssuredGet()
	{
		Response response = RestAssured
		  .get("https://restful-booker.herokuapp.com/booking")
		  .then()
		  .body("size()", Matchers.is(10))
		  .extract()
		  .response();
		
		System.out.println(response.asString());
		
		response.prettyPrint();
		
		int bookinId = response.jsonPath().getInt("[5].bookingid");
		
		System.out.println(bookinId);	
		
		
		int i = response.jsonPath().getList("$").size();
		System.out.println(i);
		
		
	}

}
