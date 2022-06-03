package com.flightbooking.model.entity;







import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;



import lombok.Data;

@Entity
@Data
public class Flight {
	


	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 long flightId;
	String flightName;
	String flightModel;
	 int seatCapacity;
     String day;
	
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "route_id", nullable = false)
	 Route routeId;
     String boardingTime;
	 String arrivalTime;
	
	
public Flight() {
	
}

	public Flight( Long flightId,String flightName, String flightModel, int seatCapacity, String day, Route routeId) {
		super();
this.flightId=flightId;
		this.flightName = flightName;
		this.flightModel = flightModel;
		this.seatCapacity = seatCapacity;
		this.day = day;
		this.routeId = routeId;
	}

	
}
