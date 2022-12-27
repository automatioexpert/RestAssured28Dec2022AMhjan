package BasicsOfRestAssured;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetRequest8 {
	
	
	@Test
	public void restAssuredGet()
	{
		
		
		Response response = RestAssured
		  .get("https://restful-booker.herokuapp.com/booking/10");
		
//		Headers headers = response.getHeaders();
//		
//		for(Header h : headers)
//		{
//			System.out.println(h.getName() +" : "+h.getValue());
//		}
		
		
		System.out.println(response.getHeader("Connection"));
		
	}

}
