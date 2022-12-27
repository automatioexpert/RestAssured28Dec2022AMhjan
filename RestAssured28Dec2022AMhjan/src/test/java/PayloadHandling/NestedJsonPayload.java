package PayloadHandling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class NestedJsonPayload {
	
	@Test
	public void createdNestedPayload()
	{
		// Skills
		Map<String,Object> skill1 = new HashMap<>();
		skill1.put("sub", "Java");
		skill1.put("exp", 5);
		skill1.put("proficiency", "Intermediate");
		
		Map<String,Object> skill2 = new HashMap<>();
		skill2.put("sub", "Selenium");
		skill2.put("proficiency", "Intermediate");
		
		List<Map<String,Object>> allSKills = new ArrayList<Map<String,Object>>();
		allSKills.add(skill1);
		allSKills.add(skill2);
		
		
		List<String> mobile = new ArrayList<String>();
		mobile.add("1321241324");
		mobile.add("2545534543");
		
		// Final pyualod
		Map<String,Object> finalPayload = new HashMap<>();
		finalPayload.put("mobile", mobile);
		finalPayload.put("skills", allSKills);
		
		RestAssured
		.given()
			.log()
			.all()
			.contentType(ContentType.JSON)
			.baseUri("https://restful-booker.herokuapp.com/")
			.body(finalPayload)
		.when()
			.post("booking")
		.then()
			.log()
			.all()
			.statusCode(200);
		
	}

}
