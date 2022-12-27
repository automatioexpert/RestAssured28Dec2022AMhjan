package JsonNodeExamples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ArrayNodeExample {
	
	public static void main(String[] args) throws JsonProcessingException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		ArrayNode payload = objectMapper.createArrayNode(); // List
		
		
		ObjectNode createBookingPayload = objectMapper.createObjectNode();
		
		createBookingPayload.put("firstname", "Amod");
		createBookingPayload.put("lastname", "Mahajan");
		createBookingPayload.put("totalprice", 111);
		createBookingPayload.put("depositpaid", true);
		createBookingPayload.put("additionalneeds", "Lunch");
		
		
		ObjectNode bookingDates = objectMapper.createObjectNode();
		bookingDates.put("checkin", "2019-01-01");
		bookingDates.put("checkout", "2020-01-01");
		
		createBookingPayload.set("bookingdates", bookingDates);
		
		
		payload.add(createBookingPayload);
		
		
		String payloadAsString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(payload);
		System.out.println(payloadAsString);
		
		
		
		
		//System.out.println(createBookingPayload.get("firstname"));
	}

}
