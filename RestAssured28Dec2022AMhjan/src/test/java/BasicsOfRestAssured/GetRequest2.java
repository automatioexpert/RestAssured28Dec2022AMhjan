package BasicsOfRestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;




public class GetRequest2 {
	
	
	@Test
	public void restAssuredGet()
	{
		Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking/1");
		
		int statusCode1 = response.statusCode();
		System.out.println(statusCode1);
		Assert.assertEquals(200, 200);
		
		int statusCode2 = response.getStatusCode();
		System.out.println(statusCode2);
		
		String statusLine = response.getStatusLine();
		System.out.println(statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}

}
