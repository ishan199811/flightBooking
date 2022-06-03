package com.flightbooking.model.dto;




import lombok.Data;

@Data
public class FlightDto {
	
	
	
	private String flightName;
	private String flightModel;
	private int seatCapacity;
	private String day;
	 private String boardingTime;
		private String arrivalTime;
	private Long routeId;
	
	

}
