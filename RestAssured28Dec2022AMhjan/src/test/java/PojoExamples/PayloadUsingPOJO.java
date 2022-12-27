package PojoExamples;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;

public class PayloadUsingPOJO {

	
	@Test
	public void createBooking() throws JsonProcessingException
	{
		
		CreateBookingPayload createBookingPayload1 = new CreateBookingPayload();
		createBookingPayload1.setFirstname("Amod");
		createBookingPayload1.setLastname("Mahajan");
		createBookingPayload1.setAdditionalneeds("Lunch");
		createBookingPayload1.setDepositpaid(true);
		createBookingPayload1.setTotalprice(222);
		
		Bookingdates bookingdates = new Bookingdates();
		bookingdates.setCheckin("2018-01-01");
		bookingdates.setCheckout("2018-01-01");
		
		createBookingPayload1.setBookingdates(bookingdates);
		
		
		CreateBookingPayload createBookingPayload2 = new CreateBookingPayload();
		createBookingPayload2.setFirstname("Manish");
		createBookingPayload2.setLastname("Kumar");
		createBookingPayload2.setAdditionalneeds("Dinner");
		createBookingPayload2.setDepositpaid(true);
		createBookingPayload2.setTotalprice(333);
		
		Bookingdates bookingdates2 = new Bookingdates();
		bookingdates2.setCheckin("2019-01-01");
		bookingdates2.setCheckout("2020-01-01");
		
		createBookingPayload1.setBookingdates(bookingdates2);
		
		
		List<CreateBookingPayload> listOfPass = new ArrayList<>();
		listOfPass.add(createBookingPayload1);
		listOfPass.add(createBookingPayload2);
		
		
		ObjectMapper mapper = new ObjectMapper();
		String payload = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(listOfPass);
		System.out.println(payload);
		
		
		
		
//		Map<String,Object> response = RestAssured
//			.given()
//				.log()
//				.all()
//				.contentType(ContentType.JSON)
//				.baseUri("https://restful-booker.herokuapp.com/")
//				.body("{\r\n" + 
//						"    \"firstname\" : \"Jim\",\r\n" + 
//						"    \"lastname\" : \"Brown\",\r\n" + 
//						"    \"totalprice\" : 111,\r\n" + 
//						"    \"depositpaid\" : true,\r\n" + 
//						"    \"bookingdates\" : {\r\n" + 
//						"        \"checkin\" : \"2018-01-01\",\r\n" + 
//						"        \"checkout\" : \"2019-01-01\"\r\n" + 
//						"    },\r\n" + 
//						"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
//						"}")
//			.when()
//				.post("booking")
//			.then()
//				.log()
//				.all()
//				.statusCode(200)
//				.extract()
//				.as(new TypeRef<Map<String,Object>>(){});
//				
//				Set<String> s = response.keySet();
//				for(String s1: s)
//					System.out.println(s1);
//				
//				
//				Object bookingDetails = response.get("booking");
//				Map<String,Object> bd = (Map<String,Object>) bookingDetails;
//				System.out.println(bd.get("firstname"));
//				System.out.println(bd.get("totalprice"));
//				
//				
//				Map<String,Object> bDates = (Map<String,Object>)bd.get("bookingdates");
//				System.out.println(bDates);
//				System.out.println(bDates.get("checkin"));
		
	}
}
