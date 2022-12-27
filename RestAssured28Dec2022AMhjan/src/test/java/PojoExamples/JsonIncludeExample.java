package PojoExamples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonIncludeExample {
	
	public static void main(String[] args) throws JsonProcessingException {
		
		CreateBookingPayload createBookingPayload = new CreateBookingPayload();
		
		createBookingPayload.setFirstname("Amod");
		createBookingPayload.setLastname("Mahajan");
		createBookingPayload.setTotalprice(0);
		
		ObjectMapper mapper = new ObjectMapper();
		String payload = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(createBookingPayload);
		System.out.println(payload);
	}

}
