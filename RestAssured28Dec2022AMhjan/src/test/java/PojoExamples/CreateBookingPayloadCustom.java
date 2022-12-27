package PojoExamples;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(value = {"depositpaid","additionalneeds"})
public class CreateBookingPayloadCustom extends CreateBookingPayload{
		
	
	
}
