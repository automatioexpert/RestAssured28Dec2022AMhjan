package BasicsOfRestAssured;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;




public class GetRequest4 {
	
	
	@Test
	public void restAssuredGet()
	{
		Response response = RestAssured
		  .get("https://restful-booker.herokuapp.com/booking/10");
		
		
		String firstNameVal = response.jsonPath().get("firstname").toString();
		System.out.println(firstNameVal);
		
		String firstNameVal1 = response.jsonPath().getString("firstname");
		System.out.println(firstNameVal1);
		
		Object obj = response.jsonPath().get("firstname");
		System.out.println(obj instanceof String);
		System.out.println(obj instanceof Boolean);
		System.out.println(obj instanceof Integer);
		
		
		if(obj instanceof String)
			System.out.println(obj.toString());
		else if(obj instanceof Integer)
		{
			int i = (Integer)obj;
			System.out.println(i);
		}
		
	}

}
