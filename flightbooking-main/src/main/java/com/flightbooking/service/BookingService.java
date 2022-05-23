package com.flightbooking.service;

import java.text.ParseException;
import java.util.List;


import com.flightbooking.model.entity.Booking;

import com.flightbooking.model.entity.Passenger;
import com.flightbooking.model.response.ResponseMessage;

public interface BookingService {

	ResponseMessage saveBooking(Booking booking);

	ResponseMessage getBookingById(Long id);



	ResponseMessage savePassenger(List<Passenger> passenger, long flightId, String bookingDate) throws ParseException;
	
}
