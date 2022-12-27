package JsonNodeExamples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExtractingValueFromJsonArrayUsingJsonNode2 {
	
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		
		String json = "[\r\n" + 
				"  {\r\n" + 
				"    \"firstname\": \"Amod\",\r\n" + 
				"    \"lastname\": \"Mahajan\",\r\n" + 
				"    \"totalprice\": 222,\r\n" + 
				"    \"depositpaid\": true,\r\n" + 
				"    \"additionalneeds\": \"Lunch\",\r\n" + 
				"    \"bookingdates\": {\r\n" + 
				"      \"checkin\": \"2019-01-01\",\r\n" + 
				"      \"checkout\": \"2020-01-01\"\r\n" + 
				"    }\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"firstname\": \"Manish\",\r\n" + 
				"    \"lastname\": \"Kumar\",\r\n" + 
				"    \"totalprice\": 333,\r\n" + 
				"    \"depositpaid\": true,\r\n" + 
				"    \"additionalneeds\": \"Dinner\",\r\n" + 
				"    \"bookingdates\": null\r\n" + 
				"  }\r\n" + 
				"]";
		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonAsJsonNode = objectMapper.readTree(json);
		
		System.out.println(jsonAsJsonNode.get(1).get("firstname").asText());
		
	}

}
