package PojoExamples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonIgnoreExample {

	public static void main(String[] args) throws JsonProcessingException {

		CreateBookingPayloadCustom createBookingPayload = new CreateBookingPayloadCustom();

		createBookingPayload.setFirstname("Amod");
		createBookingPayload.setLastname("Mahajan");
		
		createBookingPayload.setAdditionalneeds("Lunch");
		
		ObjectMapper mapper = new ObjectMapper();
		String payload = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(createBookingPayload);
		System.out.println(payload);
	}
}
