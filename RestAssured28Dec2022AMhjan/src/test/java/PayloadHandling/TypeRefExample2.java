package PayloadHandling;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;

public class TypeRefExample2 {
	
	@Test
	public void createBooking()
	{
		Object response = RestAssured
			.given()
				.log()
				.all()
				.contentType(ContentType.JSON)
				.baseUri("https://restful-booker.herokuapp.com/")
				.body("{\r\n" + 
						"    \"firstname\" : \"Jim\",\r\n" + 
						"    \"lastname\" : \"Brown\",\r\n" + 
						"    \"totalprice\" : 111,\r\n" + 
						"    \"depositpaid\" : true,\r\n" + 
						"    \"bookingdates\" : {\r\n" + 
						"        \"checkin\" : \"2018-01-01\",\r\n" + 
						"        \"checkout\" : \"2019-01-01\"\r\n" + 
						"    },\r\n" + 
						"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
						"}")
			.when()
				.post("booking")
			.then()
				.log()
				.all()
				.statusCode(200)
				.extract()
				.as(new TypeRef<Object>(){});
		
		System.out.println(response);
		
		if(response instanceof Map)
		{
			Map<String,Object> responseMap = (Map<String,Object>) response;
			System.out.println(((Map) response).keySet());
		}
		else if(response instanceof List)
		{
			List<Map<String,Object>> responseList = (List<Map<String,Object>>)response;
			System.out.println(responseList.size());
		}
				
				
				
		
		
		
		
		
	}

}
