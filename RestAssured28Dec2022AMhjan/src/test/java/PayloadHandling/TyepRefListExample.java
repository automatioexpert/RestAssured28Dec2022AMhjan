package PayloadHandling;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class TyepRefListExample {
	
	@Test
	public void getAllBookings()
	{
		List<Map<String,Object>> allBookings = RestAssured
		 .get("https://restful-booker.herokuapp.com/booking")
		 .as(new TypeRef<List<Map<String,Object>>>() {});
		
		System.out.println(allBookings.size());
		
		Map<String,Object> b = allBookings.get(0);
		System.out.println(b.get("bookingid"));
		
		for(Map<String,Object> booking : allBookings)
		{
			System.out.println(booking.get("bookingid"));
		}
	}

}
