package PayloadHandling;

import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;

public class TypeRefExample {
	
	@Test
	public void createBooking()
	{
		Map<String,Object> response = RestAssured
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
				.as(new TypeRef<Map<String,Object>>(){});
				
				Set<String> s = response.keySet();
				for(String s1: s)
					System.out.println(s1);
				
				
				Object bookingDetails = response.get("booking");
				Map<String,Object> bd = (Map<String,Object>) bookingDetails;
				System.out.println(bd.get("firstname"));
				System.out.println(bd.get("totalprice"));
				
				
				Map<String,Object> bDates = (Map<String,Object>)bd.get("bookingdates");
				System.out.println(bDates);
				System.out.println(bDates.get("checkin"));
				
				
		
		
		
		
		
	}

}
