package com.flightbooking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.flightbooking.model.entity.Flight;
import com.flightbooking.model.entity.Route;
import com.flightbooking.model.response.ResponseMessage;
import com.flightbooking.repository.FlightRepository;

@SpringBootTest
public class FlightServiceTest {
	@Autowired
	FlightService service;
	
	@MockBean
	FlightRepository repo;
	
	@Before(value = "")
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	 @Test
	 void retrieveAllItems_basic() {
	
	verify(service).getAllFlight();
	 
	 }
	 
	
	 @Test
	 void getAllFlight()
	    {
		 Route route=new Route();
		
		 
		 when(repo.findAll()).thenReturn(Stream.of(new Flight((long) 1,"indigo","is3131",32,"monday",route),
				 new Flight((long) 1,"air india","is313",32,"tuesday",route)).collect(Collectors.toList()));
	       assertEquals(2,service.getAllFlight());
	    }
		
}
