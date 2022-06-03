package com.flightbooking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.boot.test.context.SpringBootTest;


import com.flightbooking.model.dto.BookingDto;
import com.flightbooking.model.entity.Booking;
import com.flightbooking.model.entity.Flight;
import com.flightbooking.model.entity.Passenger;
import com.flightbooking.model.entity.Route;
import com.flightbooking.repository.BookingRepository;
import com.flightbooking.repository.FlightRepository;
import com.flightbooking.repository.PassengerRepository;
import com.flightbooking.service.serviceImpl.BookingServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
 class BookingServiceTest {
	
	
	
	
	@InjectMocks
	BookingServiceImpl bookingService;
	
	@Mock
	BookingRepository bookRepo;
	
	@Mock
	PassengerRepository passengerRepo;
	
	@Mock
	FlightRepository flyrepo;
	
	
	//geeting present date and time
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date myDate = new Date();
			String day = sdf.format(myDate);
	
	@Test
	 void getBookingTest() {
		long id=1;
		Route root=new Route();
		root= new Route(1L,"bombay","delhi");
		
		Flight flight=new Flight(1L,"indigo","is3131",32,"Monday",root);
		
		Set<Passenger> passengers=new HashSet<Passenger>();
		
		Booking booking=new Booking(1L,"06/07/2022",32,flight ,passengers,day);
		
		
		
		when(bookRepo.getById(id)).thenReturn(booking);
		
		assertEquals(booking,bookingService.getBookingById(id).getData());
		
		
	}
	
	@Test
	 void doBooking() throws ParseException { 
	
		Route root=new Route();
		root= new Route(1L,"bombay","delhi");
		
		Flight flight=new Flight(1L,"indigo","is3131",32,"Monday",root);
		
		
		
		Set<Passenger> passengers=new HashSet<Passenger>();
		List<Passenger> passenger=new ArrayList<Passenger>();
		Booking booking=new Booking(1L,day,2,flight ,passengers,"06/07/2022");
		BookingDto bookingDto=new BookingDto("06/07/2022",1L,passenger);

		
		when(flyrepo.getById(bookingDto.getFlightId())).thenReturn(flight);
		when(passengerRepo.saveAll(passenger)).thenReturn(passenger);
		when(bookRepo.save(booking)).thenReturn(booking);
		
		assertEquals(booking,bookingService.savePassenger(bookingDto).getData());
		
	}
	
	
	

}
