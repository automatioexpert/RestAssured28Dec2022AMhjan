package BasicsOfRestAssured;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;




public class GetRequest10 {
	
	
	@Test
	public void restAssuredGet()
	{
		Response response = RestAssured
		  .get("https://restful-booker.herokuapp.com/booking/10");
		
		
		System.out.println(response.asString());
		
		response.prettyPrint();
		
	}

}
