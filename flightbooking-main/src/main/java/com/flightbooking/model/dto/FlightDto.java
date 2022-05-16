package com.flightbooking.model.dto;


import javax.persistence.Id;

import lombok.Data;

@Data
public class FlightDto {
	
	@Id
	
	private Long flightId;
	
	private String flightName;
	private String flightModel;
	private int seatCapacity;
	private String day;
	
	private Long routeId;
	
	

}
