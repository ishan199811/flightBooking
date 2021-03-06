package com.flightbooking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.boot.test.context.SpringBootTest;



import com.flightbooking.api.data.FlightSearch1;
import com.flightbooking.model.entity.Flight;
import com.flightbooking.model.entity.Route;

import com.flightbooking.repository.FlightRepository;
import com.flightbooking.repository.RouteRepository;
import com.flightbooking.service.serviceImpl.FlightServiceImpl;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
 class FlightServiceTest {

	@InjectMocks
	FlightServiceImpl service;
	
	@Mock
	FlightRepository repo;
	
	@Mock
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
		
		when(rrepo.findFlightBySourceAndDestination(fs.getSource(),fs.getDestination())).thenReturn(root);
		when(repo.findFlightByRouteId(root)).thenReturn(fly);
		assertEquals(fly,service.getflightbyroute(fs).getData());
		
		}

	
	//test method for getAllFlight	
@Test
void getAllFlight() {
	Route root=new Route();
	List<Flight> fly=new ArrayList<Flight>();
	fly.add(new Flight( 1L,"indigo","is3131",32,"Monday",root));
	fly.add(new Flight( 2L,"AirIndia","is3133",32,"tuesday",root));
	fly.add(new Flight(3L,"indiaair","is3132",32,"wednesday",root));
	
	when(repo.findAll()).thenReturn(fly);
	assertEquals(fly,service.getAllFlight().getData());

}
//test method for getConnectingFlight
	 @Test
	 void getConnectingFlight() throws ParseException {
		
			FlightSearch1 fs=new FlightSearch1("bombay","delhi","06/06/2022");	
		 
		 Route route=new Route(1L,"bombay","indore");
		 
		 List<Route> root=new ArrayList<Route>();
			root.add(route);
		
			Route route1=new Route(2L,"indore","delhi");
			 List<Route> root2=new ArrayList<Route>();
				root2.add(route1);
				root2.addAll(root);	
				List<Route> filteredRoute=new ArrayList<Route>();
				filteredRoute.add(route);
				filteredRoute.add(route1);
				
			List<Flight> fly=new ArrayList<Flight>();
			fly.add(new Flight( 1L,"indigo","is3131",32,"Monday",route));
			fly.add(new Flight( 2L,"AirIndia","is3133",32,"Monday",route1));
			when(rrepo.findBySource(fs.getSource())).thenReturn(root);
			when(rrepo.findByDestination(fs.getDestination())).thenReturn(root2);
			when(repo.findByRouteId(filteredRoute)).thenReturn(fly);
			assertEquals(fly,service.getConnectingFlight(fs).getData());
	 }

}
