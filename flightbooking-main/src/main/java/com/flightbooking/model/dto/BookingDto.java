package com.flightbooking.model.dto;

import java.util.Date;
import java.util.List;

import com.flightbooking.model.entity.Passenger;

import lombok.Data;

@Data
public class BookingDto {
	
	private String bookingDate;
	
	public BookingDto(String bookingDate, long flightId, List<Passenger> passenger) {
		super();
		this.bookingDate = bookingDate;
		this.flightId = flightId;
		this.passenger = passenger;
	}
	private long flightId;
	private List<Passenger> passenger;
	

}
