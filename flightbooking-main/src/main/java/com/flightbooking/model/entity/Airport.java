package com.flightbooking.model.entity;




import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Airport {
	
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	private Long airportId;
	private String airportLocation;
	private String airportName;
	/*
	 * @ManyToMany(mappedBy = "airport") private Set<Flight> flight;
	 */
	
	


}
