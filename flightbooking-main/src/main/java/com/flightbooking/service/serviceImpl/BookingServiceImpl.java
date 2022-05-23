package com.flightbooking.service.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.model.dto.BookingDto;
import com.flightbooking.model.entity.Booking;
import com.flightbooking.model.entity.Flight;
import com.flightbooking.model.entity.Passenger;
import com.flightbooking.model.response.ResponseMessage;
import com.flightbooking.repository.BookingRepository;
import com.flightbooking.repository.FlightRepository;
import com.flightbooking.repository.PassengerRepository;
import com.flightbooking.service.BookingService;


@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	BookingRepository bookrepo;
	
	@Autowired
	PassengerRepository passRepo;
	
	@Autowired
	FlightRepository flyrepo;

	
	@Override
	public ResponseMessage saveBooking(Booking booking) {
		bookrepo.save(booking);
		return ResponseMessage.builder().message("Booking have been done succesfully").build();
	}

	
	//booking for flight
@Override
public ResponseMessage savePassenger(BookingDto bookingDto) throws ParseException {
	List<Passenger> pass=new ArrayList<>();
	pass.addAll(bookingDto.getPassenger());
	Booking book=new Booking();
	
	
	
	//geeting present date and time
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date myDate = new Date();
	String day = sdf.format(myDate);
     book.setBookingDate(day);
	
     //geting flight by Id
	Flight fl=flyrepo.getById(bookingDto.getFlightId());
		book.setFlightId(fl);
	
		//getting number of passengers
	int l=pass.size();
	//setting number of passengers
	book.setNoOfPassengers(l);
	//saving booking info
	bookrepo.save(book);

	//Checking booking id and flight info for the particular passenger
	for(Passenger pas:pass) {
		if(pas.getBookingId()==null) {
			pas.setBookingId(book);
		}
		if(pas.getDepartureDate()==null) {
			pas.setDepartureDate(bookingDto.getBookingDate());
		}
		if(pas.getFlight()==null) {
			pas.setFlight(fl);
		}
	}
	//saving passenger info
    passRepo.saveAll(pass);
    
   
    
	return ResponseMessage.builder().message("this is your booking").data(book ).build();
	
}
	
	
	@Override
	public ResponseMessage getBookingById(Long id) {
    Booking book=bookrepo.getById(id);
		return ResponseMessage.builder().message("this is your booking").data(book).build();
	}

}
