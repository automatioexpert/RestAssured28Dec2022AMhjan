package BasicsOfRestAssured;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RequestSpecificationDemo {
	
	private static RequestSpecification requestSpecification;
	private static ResponseSpecification responseSpecification;
	
	@BeforeClass
	public void setupRequestSpecification()
	{
		requestSpecification = RestAssured.given();
		requestSpecification.baseUri("https://restful-booker.herokuapp.com/")
		.basePath("booking")
		.contentType(ContentType.JSON)
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
		.log().all();
		
		responseSpecification = RestAssured.expect();
		responseSpecification.log().all()
		.statusCode(200)
		.contentType(ContentType.JSON);
	}
	
	@Test
	public void directCall()
	{
		requestSpecification.post();
	}
	
	@Test
	public void createBooking1()
	{
		RestAssured
			.given(requestSpecification)
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
				.post()
			.then()
				.statusCode(201);
	}
	
	@Test
	public void createBooking2()
	{
		RestAssured
			.given(requestSpecification)
				.body("{\r\n" + 
						"    \"firstname\" : \"Amod\",\r\n" + 
						"    \"lastname\" : \"Mahajan\",\r\n" + 
						"    \"totalprice\" : 111,\r\n" + 
						"    \"depositpaid\" : true,\r\n" + 
						"    \"bookingdates\" : {\r\n" + 
						"        \"checkin\" : \"2018-01-01\",\r\n" + 
						"        \"checkout\" : \"2019-01-01\"\r\n" + 
						"    },\r\n" + 
						"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
						"}")
			.when()
				.post()
			.then()
			.spec(responseSpecification);			
	}
	
	
	@Test
	public void createAuth()
	{
		//requestSpecification.basePath("auth");
		RestAssured
			.given(requestSpecification)
			.basePath("auth")
				.body("{\r\n" + 
						"    \"username\" : \"admin\",\r\n" + 
						"    \"password\" : \"password123\"\r\n" + 
						"}")
			.when()
				.post()
			.then()
				.log()
				.all()
				.statusCode(200);		
	}
	
	
	@Test
	public void createBooking3()
	{
		RestAssured
			.given(requestSpecification)
				.body("{\r\n" + 
						"    \"firstname\" : \"Amod\",\r\n" + 
						"    \"lastname\" : \"Mahajan\",\r\n" + 
						"    \"totalprice\" : 111,\r\n" + 
						"    \"depositpaid\" : true,\r\n" + 
						"    \"bookingdates\" : {\r\n" + 
						"        \"checkin\" : \"2018-01-01\",\r\n" + 
						"        \"checkout\" : \"2019-01-01\"\r\n" + 
						"    },\r\n" + 
						"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
						"}")
			.when()
				.post()
			.then()
			.spec(responseSpecification);		
	}

}
