package com.flightbooking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.flightbooking.api.data.FlightSearch1;
import com.flightbooking.model.entity.Flight;
import com.flightbooking.model.entity.Route;

import com.flightbooking.repository.FlightRepository;
import com.flightbooking.repository.RouteRepository;



@SpringBootTest
 class FlightServiceTest {

	@Autowired
	FlightService service;
	
	@MockBean
	FlightRepository repo;
	
	@MockBean
	RouteRepository rrepo;
	
	
	
	
	//test method for filtering flight
	@Test
    void checkFlightFilter() throws ParseException {
		Route root=new Route();
		root= new Route(1L,"bombay","delhi");
		FlightSearch1 fs=new FlightSearch1("bombay","delhi","06/06/2022");	
		List<Flight> fly=new ArrayList<Flight>();
		fly.add(new Flight( 1L,"indigo","is3131",32,"Monday",root));
		fly.add(new Flight( 2L,"AirIndia","is3133",32,"Monday",root));
		fly.add(new Flight(3L,"indiaair","is3132",32,"Monday , Tuesday",root));
		when(rrepo.findFlightBySourceAndDestination(root.getSource(),root.getDestination())).thenReturn(root);
		when(repo.findFlightByRouteId(root)).thenReturn(fly);
		assertEquals(fly,service.getflightbyroute(fs).data);
		
		}

	
//for getAllFlight	
@Test
void getAllFlight() {
	Route root=new Route();
	List<Flight> fly=new ArrayList<Flight>();
	fly.add(new Flight( 1L,"indigo","is3131",32,"Monday",root));
	fly.add(new Flight( 2L,"AirIndia","is3133",32,"tuesday",root));
	fly.add(new Flight(3L,"indiaair","is3132",32,"wednesday",root));
	when(repo.findAll()).thenReturn(fly);
	assertEquals(fly,service.getAllFlight().data);

}
//getConnectingFlight
	 @Test
	 void getConnectingFlight() {
		 
		 
	 }

}
