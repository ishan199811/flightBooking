package com.flightbooking.model.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.Data;

@Entity
@Data
public class Booking {
	
	@Id
 @GeneratedValue(strategy=GenerationType.AUTO)
	private Long bookingId;
	
	private String bookingDate;

	private int noOfPassengers;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "flight_Id", nullable = false)
	private Flight flightId; 

	@OneToMany(fetch = FetchType.LAZY,mappedBy="bookingId", cascade =
	 CascadeType.ALL) private Set<Passenger> passenger;
	 
	  
	  
	  public Booking(Long bookingId, String bookingDate, int noOfPassengers, Flight flightId, Set<Passenger> passenger) {
			super();
			this.bookingId = bookingId;
			this.bookingDate = bookingDate;
			this.noOfPassengers = noOfPassengers;
			this.flightId = flightId;
			this.passenger = passenger;
		}



	public Booking() {
		
	}
	
}
