package com.flightbooking.api.data;

import com.flightbooking.model.entity.Airport;

import lombok.Data;

@Data
public class FlightSearch1 {
	

public FlightSearch1(String source, String destination, String date) {
	this.source=source;
	this.destination=destination;
	this.date=date;
	}

private String source;
	 
private	 String destination;

private String date;
}
