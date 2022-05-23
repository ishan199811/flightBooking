package com.flightbooking.model.dto;


import javax.persistence.Id;

import lombok.Data;

@Data
public class PaasengerDto {
	
	@Id
	private Long passengerId;
	
	private String passengerName;
	
	private int passengerAge;
	private String date;
	
	private String address;
	private long flightId;
private 	long bookingId;

}
