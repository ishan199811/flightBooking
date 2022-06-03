package com.flightbooking.model.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



import lombok.Data;

@Entity
@Data
public class Passenger {

	

	

	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	private long passengerId;
	
	
	private String passengerName;
	
	private int passengerAge;
	
	private String address;
	
	@OneToOne
	private Flight flight; 
	
	private String departureDate;
	
	  
	 @ManyToOne(fetch = FetchType.LAZY)  
	 @JoinColumn(name = "booking_id", nullable = true) 
	 private Booking bookingId;
	 
	 public Passenger() {
		 
	 }
	 
	 
	 public Passenger(Long passengerId, String passengerName, int passengerAge, String address, Flight flight,
				String departureDate, Booking bookingId) {
			super();
			this.passengerId = passengerId;
			this.passengerName = passengerName;
			this.passengerAge = passengerAge;
			this.address = address;
			this.flight = flight;
			this.departureDate = departureDate;
			this.bookingId = bookingId;
		}

	
}
