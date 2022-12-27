package JsonSchemaValidation;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class VerifyJsonSchema {
	
	@Test
	public void ds() {
		
		File schema = new File("C:\\Amod Mahajan Personal Stuffs\\Online Training\\OnlineTrainingWorkspace\\RestAssuredBatchAug\\src\\test\\java\\JsonSchemaValidation\\CreateBookingSchema.json");
		RestAssured
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
			.body(JsonSchemaValidator.matchesJsonSchema(schema));
	}

}
