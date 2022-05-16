package com.flightbooking.model.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Passenger {

	

	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	private Long passengerId;
	
	private String passengerName;
	
	private int passengerAge;
	
	private String address;
	
	@OneToOne
	private Flight flight; 
	
	private String departureDate;
	
	 @JsonIgnore	  
	 @ManyToOne(fetch = FetchType.LAZY)  
	 @JoinColumn(name = "booking_id", nullable = true) 
	 private Booking bookingId;
	
}
