package PojoResponse;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRequest {
	
	@Test
	public void createBooking()
	{
		CreateBookingResponsePojo createBookingResponsePojo = RestAssured
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
				.as(new TypeRef<CreateBookingResponsePojo>(){});
		
		
		int bookingId = createBookingResponsePojo.getBookingid();
		System.out.println(bookingId);
		
		
		//System.out.println(createBookingResponsePojo.getBooking().getBookingdates().getCheckin());
				
		
		
		
		
		
	}

}
