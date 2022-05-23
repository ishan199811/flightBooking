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
	private Long flightId;
	private String flightName;
	private String flightModel;
	private int seatCapacity;
    private String day;
	
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "route_id", nullable = false)
	private Route routeId;
    private String boardingTime;
	private String arrivalTime;
	
	
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
