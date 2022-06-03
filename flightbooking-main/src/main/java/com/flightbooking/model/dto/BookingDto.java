package com.flightbooking.model.dto;


import java.util.List;


import com.flightbooking.model.entity.Passenger;

import lombok.Data;

@Data
public class BookingDto {
	
	private String departureDate;
	
	
	private long flightId;
	private List<Passenger> passenger;
	
	
	public BookingDto(String departureDate, long flightId, List<Passenger> passenger) {
		super();
		this.departureDate = departureDate;
		this.flightId = flightId;
		this.passenger = passenger;
	}
	
	
	public BookingDto() {
	}

}
