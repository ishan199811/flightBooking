package com.flightbooking.service.serviceImpl;

import org.springframework.stereotype.Service;

import com.flightbooking.model.dto.FlightDto;

import com.flightbooking.model.response.ResponseMessage;
import com.flightbooking.service.ValidationService;

@Service
public class ValidationServiceImpl implements ValidationService {
	
	
	@Override
	public ResponseMessage validFlight(FlightDto flight) {
	Long id=flight.getRouteId();
		
		if(flight.getFlightName().equals(null)&&flight.getFlightName().equals("")) {
			return ResponseMessage.builder().status("0").message("Flight Name cannot be Empty").build();
		}
		 
		 if(id==null) {
			 return ResponseMessage.builder().status("0").message("Select route for flight").build();
		 }
		 return ResponseMessage.builder().status("1").build();
	}
	
	
	
	
	

}
