package com.flightbooking.model.dto;

import java.util.Date;
import java.util.List;

import com.flightbooking.model.entity.Passenger;

import lombok.Data;

@Data
public class BookingDto {
	
	private String bookingDate;
	private int noOfPassengers;
	private long flightId;
	private List<Passenger> passenger;
	

}
