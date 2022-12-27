package BasicsOfRestAssured;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PutRequest {
	
	private static String token = null;
	
	@BeforeMethod
	public void generateToken()
	{
		token = RestAssured
		.given()
			.log()
			.all()
			.contentType(ContentType.JSON)
			.baseUri("https://restful-booker.herokuapp.com/")
			.body("{\r\n" + 
					"    \"username\" : \"admin\",\r\n" + 
					"    \"password\" : \"password123\"\r\n" + 
					"}")
		.when()
			.post("auth")
		.then()
			.log()
			.all()
			.statusCode(200)
			.extract()
			.jsonPath()
			.getString("token");
	
}
	
	
	@Test
	public void apdateBooking()
	{
		RestAssured
			.given()
				.log()
				.all()
				.contentType(ContentType.JSON)
				.header("Cookie", "token="+token)
				.baseUri("https://restful-booker.herokuapp.com/")
				.body("{\r\n" + 
						"    \"firstname\" : \"Manish\",\r\n" + 
						"    \"lastname\" : \"Kumar\",\r\n" + 
						"    \"totalprice\" : 888,\r\n" + 
						"    \"depositpaid\" : true,\r\n" + 
						"    \"bookingdates\" : {\r\n" + 
						"        \"checkin\" : \"2021-01-01\",\r\n" + 
						"        \"checkout\" : \"2022-01-01\"\r\n" + 
						"    },\r\n" + 
						"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
						"}")
			.when()
				.put("booking/1")
			.then()
				.log()
				.all()
				.statusCode(200);
				
		
		
		
		
		
	}
	

}
