package com.flightbooking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.flightbooking.model.dto.BookingDto;
import com.flightbooking.model.entity.Booking;
import com.flightbooking.model.entity.Flight;
import com.flightbooking.model.entity.Passenger;
import com.flightbooking.model.entity.Route;
import com.flightbooking.repository.BookingRepository;
import com.flightbooking.repository.FlightRepository;
import com.flightbooking.repository.PassengerRepository;

@SpringBootTest
public class BookingServiceTest {
	
	
	
	
	@Autowired
	BookingService bookingService;
	
	@MockBean
	BookingRepository bookRepo;
	
	@MockBean
	PassengerRepository passengerRepo;
	
	@MockBean
	FlightRepository flyrepo;
	
	@Test
	 void getBookingTest() {
		long id=1;
		Route root=new Route();
		root= new Route(1L,"bombay","delhi");
		
		Flight flight=new Flight(1L,"indigo","is3131",32,"Monday",root);
		
		Set<Passenger> passengers=new HashSet<Passenger>();
		
		Booking booking=new Booking(1L,"06/07/2022",32,flight ,passengers);
		
		
		
		when(bookRepo.getById(id)).thenReturn(booking);
		
		assertEquals(booking,bookingService.getBookingById(id).getData());
		
		
	}
	
	@Test
	 void doBooking() throws ParseException { 
		long id=1;
		Route root=new Route();
		root= new Route(1L,"bombay","delhi");
		
		Flight flight=new Flight(1L,"indigo","is3131",32,"Monday",root);
		
		Set<Passenger> passengers=new HashSet<Passenger>();
		List<Passenger> passenger=new ArrayList<Passenger>();
		Booking booking=new Booking(1L,"06/07/2022",2,flight ,passengers);
		BookingDto bookingDto=new BookingDto("06/07/2022",1L,passenger);

		
		when(flyrepo.getById(bookingDto.getFlightId())).thenReturn(flight);
		when(passengerRepo.saveAll(passenger)).thenReturn(passenger);
		when(bookRepo.save(booking)).thenReturn(booking);
		
		assertEquals(booking,bookingService.savePassenger(bookingDto).getData());
		
	}
	
	
	

}
