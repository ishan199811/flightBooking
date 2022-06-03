package com.flightbooking.service;

import java.text.ParseException;


import com.flightbooking.model.dto.BookingDto;
import com.flightbooking.model.entity.Booking;


import com.flightbooking.model.response.ResponseMessage;

public interface BookingService {

	ResponseMessage saveBooking(Booking booking);

	ResponseMessage getBookingById(Long id);



	

	ResponseMessage savePassenger(BookingDto bookingDto) throws ParseException;
	
}
