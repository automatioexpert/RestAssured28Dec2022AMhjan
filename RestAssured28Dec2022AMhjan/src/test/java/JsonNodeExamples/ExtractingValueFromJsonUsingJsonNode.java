package JsonNodeExamples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class ExtractingValueFromJsonUsingJsonNode {
	
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		
		String json = "{\r\n" + 
				"  \"firstname\": \"Amod\",\r\n" + 
				"  \"lastname\": \"Mahajan\",\r\n" + 
				"  \"totalprice\": 222,\r\n" + 
				"  \"depositpaid\": true,\r\n" + 
				"  \"additionalneeds\": \"Lunch\",\r\n" + 
				"  \"bookingdates\": {\r\n" + 
				"    \"checkin\": \"2019-01-01\",\r\n" + 
				"    \"checkout\": \"2020-01-01\"\r\n" + 
				"  }\r\n" + 
				"}";
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		JsonNode jsonAsJsonNode = objectMapper.readTree(json);
		
//		System.out.println(jsonAsJsonNode.get("firstname").asText());
//		System.out.println(jsonAsJsonNode.get("totalprice").asText());
//		System.out.println(jsonAsJsonNode.get("totalprice").isInt());
//		System.out.println(jsonAsJsonNode.get("depositpaid").isInt());
//		System.out.println(jsonAsJsonNode.get("depositpaid").asText());
//		System.out.println(jsonAsJsonNode.get("depositpaid").isTextual());
//		
//		System.out.println(jsonAsJsonNode.get("bookingdates").get("checkin").asText());
//		
//		System.out.println(jsonAsJsonNode.at("/bookingdates/checkin").asText());
//		
//		System.out.println(jsonAsJsonNode.path("dsfsfsd").asText("Some default value"));
	}

}
