package com.flightbooking.model.entity;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




public class Stop {
	
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	private Long stopId;
	
	String stopName;
	
	


}
