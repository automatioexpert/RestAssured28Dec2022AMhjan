package PayloadHandling;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PayloadAsJsonFIle {
	
	@Test
	public void payloadAsJsonFIle()
	{
		
		String dir= System.getProperty("user.dir");
		
		File payloadFile = new File(dir+"\\src\\test\\resources\\payloads\\CreateBooking.json");
		RestAssured
			.given()
			.relaxedHTTPSValidation()
				.log()
				.all()
				.contentType(ContentType.JSON)
				.baseUri("https://restful-booker.herokuapp.com/")
				.body(payloadFile)
			.when()
				.post("booking")
			.then()
				.log()
				.all()
				.statusCode(200);
		
	}
	
	@Test
	public void payloadAsXMlFIle()
	{
		
		String dir= System.getProperty("user.dir");
		File payloadFile = new File(dir+"\\src\\test\\resources\\payloads\\CreateBookingXML.xml");
		
		
		String xmlBody = "<booking>\r\n" + 
				"    <firstname>Jim</firstname>\r\n" + 
				"    <lastname>Brown</lastname>\r\n" + 
				"    <totalprice>111</totalprice>\r\n" + 
				"    <depositpaid>true</depositpaid>\r\n" + 
				"    <bookingdates>\r\n" + 
				"      <checkin>2018-01-01</checkin>\r\n" + 
				"      <checkout>2019-01-01</checkout>\r\n" + 
				"    </bookingdates>\r\n" + 
				"    <additionalneeds>Breakfast</additionalneeds>\r\n" + 
				"  </booking>";
		RestAssured
			.given()
				.log()
				.all()
				.header("Content-Type", "text/xml")
				.baseUri("https://restful-booker.herokuapp.com/")
				.body(xmlBody)
			.when()
				.post("booking")
			.then()
				.log()
				.all()
				.statusCode(200);
		
	}

}
