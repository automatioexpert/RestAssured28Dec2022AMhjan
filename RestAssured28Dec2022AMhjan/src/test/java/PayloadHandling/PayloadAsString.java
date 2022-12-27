package PayloadHandling;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PayloadAsString {

	
	public String getCustomPayload(String firstName, String lastName, int totalprice, boolean depositpaid, String checkin, String checkout,  
			String additionalneeds)
	{
		String varPayload = "{\r\n" + 
				"    \"firstname\" : \""+firstName+"\",\r\n" + 
				"    \"lastname\" : \""+lastName+"\",\r\n" + 
				"    \"totalprice\" : "+totalprice+",\r\n" + 
				"    \"depositpaid\" : "+depositpaid+",\r\n" + 
				"    \"bookingdates\" : {\r\n" + 
				"        \"checkin\" : \""+checkin+"\",\r\n" + 
				"        \"checkout\" : \""+checkout+"\"\r\n" + 
				"    },\r\n" + 
				"    \"additionalneeds\" : \""+additionalneeds+"\"\r\n" + 
				"}";
		
		return varPayload;
	}
	
	@Test
	public void PayloadAsString()
	{
		RestAssured
			.given()
				.log()
				.all()
				.contentType(ContentType.JSON)
				.baseUri("https://restful-booker.herokuapp.com/")
				.body(getCustomPayload("amod","mahajan",222,true,"2021-01-01", "2022-01-01", "breakfast"))
				.when()
				.post("booking")
			.then()
				.log()
				.all()
				.statusCode(200);
		
	}
	
	@Test
	public void PayloadAsString1()
	{
		RestAssured
			.given()
				.log()
				.all()
				.contentType(ContentType.JSON)
				.baseUri("https://restful-booker.herokuapp.com/")
				.body(getCustomPayload("rahul","arora",333,false,"2021-01-01", "2022-01-01", "lunch"))
			.when()
				.post("booking")
			.then()
				.log()
				.all()
				.statusCode(200);
		
	}

}
