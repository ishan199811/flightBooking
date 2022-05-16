package com.flightbooking.service;


import java.text.ParseException;

import com.flightbooking.api.data.FlightSearch1;
import com.flightbooking.model.dto.FlightDto;

import com.flightbooking.model.response.ResponseMessage;

public interface FlightService  {

	
	
	ResponseMessage getflightbyroute(FlightSearch1 search) throws ParseException;
	
	ResponseMessage saveFlight(FlightDto flight);

	ResponseMessage getConnectingFlight(FlightSearch1 search) throws ParseException;

	ResponseMessage getAllFlight();
	
	
}
