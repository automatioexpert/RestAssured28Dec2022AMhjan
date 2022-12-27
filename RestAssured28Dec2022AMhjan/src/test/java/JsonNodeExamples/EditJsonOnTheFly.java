package JsonNodeExamples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class EditJsonOnTheFly {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		
		String json = "{\r\n" + 
				"  \"name\": \"Tenali Ramakrishna\",\r\n" + 
				"  \"gender\": \"Male\",\r\n" + 
				"  \"email\": \"tenali.22@15ce.com\",\r\n" + 
				"  \"status\": \"Active\"\r\n" + 
				"}";
		
		
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode editJosn = mapper.readValue(json, ObjectNode.class);
		
		editJosn.put("mob", "2132131");
		
		//System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(editJosn));
		
		editJosn.put("status", "Inactive");
		
		//System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(editJosn));
		
		ObjectNode bookingDates = mapper.createObjectNode();
		bookingDates.put("checkin", "2019-01-01");
		bookingDates.put("checkout", "2020-01-01");
		
		editJosn.set("bookingDates", bookingDates);
		
		//System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(editJosn));
		
		
		
		
ArrayNode payload = mapper.createArrayNode(); // List
		
		
		ObjectNode createBookingPayload = mapper.createObjectNode();
		
		createBookingPayload.put("firstname", "Amod");
		createBookingPayload.put("lastname", "Mahajan");
		createBookingPayload.put("totalprice", 111);
		createBookingPayload.put("depositpaid", true);
		createBookingPayload.put("additionalneeds", "Lunch");
		
		
		ObjectNode bookingDates1 = mapper.createObjectNode();
		bookingDates1.put("checkin", "2019-01-01");
		bookingDates1.put("checkout", "2020-01-01");
		
		createBookingPayload.set("bookingdates", bookingDates1);
		
		
		payload.add(createBookingPayload);
		
		editJosn.set("arrayData", payload);
		
		System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(editJosn));
		
		
		
		
	}
}
