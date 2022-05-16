package com.flightbooking.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BookingDto {
	
	private Date bookingDate;
	private int noOfPassengers;
	private long flightId;

}
