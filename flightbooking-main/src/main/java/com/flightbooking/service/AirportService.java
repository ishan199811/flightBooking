package com.flightbooking.service;

import com.flightbooking.model.entity.Airport;
import com.flightbooking.model.response.ResponseMessage;

public interface AirportService {

	ResponseMessage saveair(Airport air);

	ResponseMessage getAir();
	
}
