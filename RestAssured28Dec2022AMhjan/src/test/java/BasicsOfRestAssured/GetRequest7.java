package BasicsOfRestAssured;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetRequest7 {
	
	
	@Test
	public void restAssuredGet()
	{
		RestAssured
		  .get("https://restful-booker.herokuapp.com/booking/10")
		  .then()
		  .time(Matchers.lessThanOrEqualTo(10000L));
		
		
		Response response = RestAssured
		  .get("https://restful-booker.herokuapp.com/booking/10");
		
		long l = response.getTime();
		System.out.println(l);
		
		
	}

}
