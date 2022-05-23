package com.flightbooking.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.flightbooking.model.dto.BookingDto;
import com.flightbooking.model.entity.Passenger;
import com.flightbooking.repository.BookingRepository;
import com.flightbooking.repository.PassengerRepository;

@SpringBootTest
public class BookingServiceTest {
	
	
	
	
	@Autowired
	BookingService bookingService;
	
	@MockBean
	BookingRepository bookrepo;
	
	@MockBean
	PassengerRepository passengerRepo;
	
	@Test
	 void getBookingTest() {
		
	}
	

}
