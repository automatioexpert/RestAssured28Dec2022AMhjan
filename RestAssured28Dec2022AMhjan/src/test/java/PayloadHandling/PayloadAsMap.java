package PayloadHandling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PayloadAsMap {
	
	
	@Test
	public void PayloadAsString1()
	{
		
		Map<String,String> addressMap1 = new LinkedHashMap<>();
		addressMap1.put("street", "Gururaj Layout");
		addressMap1.put("city", "BLR");
		addressMap1.put("state", "KA");
		
		
		Map<String,Object> emp1 = new LinkedHashMap<>();
		emp1.put("name", "Amod");
		emp1.put("sub", "API Testing");
		emp1.put("address", addressMap1);
		
		
		Map<String,String> addressMap2 = new LinkedHashMap<>();
		addressMap2.put("street", "Dravid Layout");
		addressMap2.put("city", "DEL");
		addressMap2.put("state", "DEL");
		
		
		Map<String,Object> emp2 = new LinkedHashMap<>();
		emp2.put("name", "Rahul");
		emp2.put("sub", "API Testing");
		emp2.put("address", addressMap2);
		
		
		List<Map<String,Object>> allEmps = new ArrayList<>();
		allEmps.add(emp1);
		allEmps.add(emp2);
		
		
		
		RestAssured
			.given()
				.log()
				.all()
				.contentType(ContentType.JSON)
				.baseUri("https://restful-booker.herokuapp.com/")
				.body(allEmps)
			.when()
				.post("booking")
			.then()
				.log()
				.all()
				.statusCode(200);
		
	}

}
