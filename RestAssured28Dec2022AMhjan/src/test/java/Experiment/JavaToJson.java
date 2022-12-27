package Experiment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaToJson {

	
	public static void main(String[] args) throws JsonProcessingException {
		
		Employee employee = new Employee();
		employee.setFirstName("Amod");
		employee.setLastName("Mahajan");
		
		// Jav aobject to a JSON object
		ObjectMapper objectMapper = new ObjectMapper();
		System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee));
		
		
		// Json object to a java object
		String jsonObject = "{\r\n" + 
				"  \"firstName\" : \"Manish\",\r\n" + 
				"  \"lastName\" : \"Sharma\"\r\n" + 
				"}";
		Employee emp = objectMapper.readValue(jsonObject, Employee.class);
		System.out.println(emp.getFirstName());
		
	}
}
