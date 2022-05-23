package com.flightbooking.model.entity;






import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;

@Entity
@Data
public class Airport {
	
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	private Long airportId;
	private String airportLocation;
	private String airportName;
	
	
	


}
