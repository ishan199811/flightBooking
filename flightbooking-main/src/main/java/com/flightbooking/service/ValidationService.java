package com.flightbooking.service;

import com.flightbooking.model.dto.FlightDto;
import com.flightbooking.model.entity.Flight;
import com.flightbooking.model.response.ResponseMessage;

public interface ValidationService {

	ResponseMessage validFlight(FlightDto flight);

}
