package com.flightbooking.repoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.flightbooking.model.entity.Flight;
import com.flightbooking.model.entity.Route;
import com.flightbooking.repository.FlightRepository;
import com.flightbooking.service.serviceImpl.FlightServiceImpl;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class FlightRepoTest {
	
	
	@InjectMocks
	FlightServiceImpl service;
	
	@Mock
	FlightRepository repo;
	
	
	 @Test
	 void getAllFlight()
	    {
		 Route route=new Route();
		
		 
		 when(repo.findAll()).thenReturn(Stream.of(new Flight((long) 1,"indigo","is3131",32,"monday",route),
				 new Flight((long) 1,"air india","is313",32,"tuesday",route)).collect(Collectors.toList()));
	       assertEquals(2,repo.findAll().size());
	    }
	 

	 @Test
	 void getAllFlights()
	    {
		 Route route=new Route();
		
		 String day="Monday";
		 when(repo.findByDay( day)).thenReturn(Stream.of(new Flight((long) 1,"indigo","is3131",32,"Monday",route),
				 new Flight((long) 1,"air india","is313",32,"tuesday",route)).collect(Collectors.toList()));
	       assertEquals(2,repo.findByDay( day).size());
	    }
	 
	 @Test
	 void getAllFlits()
	    {
		 Route route=new Route();
		String source="bombay";
				String destination="delhi";
	route.setRouteId(1);
	route.setSource(source);
	route.setDestination(destination);
		 when(repo.findFlightByRouteId(route)).thenReturn(Stream.of(new Flight((long) 1,"indigo","is3131",32,"Monday",route),
				 new Flight((long) 1,"air india","is313",32,"tuesday",route)).collect(Collectors.toList()));
		 assertEquals(false,repo.findFlightByRouteId(route).isEmpty());
	    }


}
