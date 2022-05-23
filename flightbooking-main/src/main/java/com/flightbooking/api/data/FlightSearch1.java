package com.flightbooking.api.data;



import lombok.Data;

@Data
public class FlightSearch1 {
	



private String source;
	 
private	 String destination;

private String date;

public FlightSearch1() {
}

public FlightSearch1(String source, String destination, String date) {
this.source=source;
this.destination=destination;
this.date=date;
}
}
