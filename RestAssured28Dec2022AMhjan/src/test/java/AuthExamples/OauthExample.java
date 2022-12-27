package AuthExamples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class OauthExample {
	
	public static void main(String[] args) {
		
		RestAssured
		   .given()
		   .contentType(ContentType.JSON)
		   .log()
		   .all()
		   .auth()
		   .oauth2("bacfe7a7f440ec8b23e6c5feaed9f274b222f77dee7e2601f283fd8ddea1025a")
		   .baseUri("https://gorest.co.in/public-api/users")
		   .body("{\r\n" + 
		   		"  \"name\": \"Tenali Ramakrishna\",\r\n" + 
		   		"  \"gender\": \"Male\",\r\n" + 
		   		"  \"email\": \"tenali.ramakrishna11@15ce.com\",\r\n" + 
		   		"  \"status\": \"Active\"\r\n" + 
		   		"}")
		   .post()
		   .then()
		   .log()
		   .all();
		   
	}

}
