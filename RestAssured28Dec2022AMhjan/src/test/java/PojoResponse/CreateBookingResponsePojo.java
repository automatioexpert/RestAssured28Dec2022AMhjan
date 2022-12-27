package PojoResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateBookingResponsePojo {

	private int bookingid;

	private int soneExtraField;

	public int getSoneExtraField() {
		return soneExtraField;
	}

	public void setSoneExtraField(int soneExtraField) {
		this.soneExtraField = soneExtraField;
	}

	// private CreateBookingPayload booking;
	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
//	public CreateBookingPayload getBooking() {
//		return booking;
//	}
//	public void setBooking(CreateBookingPayload booking) {
//		this.booking = booking;
//	}

}
