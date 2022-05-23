package com.flightbooking.service;

import java.util.List;

import com.flightbooking.model.dto.PaasengerDto;

import com.flightbooking.model.entity.Passenger;
import com.flightbooking.model.response.ResponseMessage;


public interface PassengerService {

	



	ResponseMessage savePassenger(List<Passenger> passenger);

	ResponseMessage findBydepartureDateAndFlight(PaasengerDto passenger);

}
