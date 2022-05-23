package com.flightbooking.controllerTest;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.flightbooking.controller.FlightController;
import com.flightbooking.model.entity.Flight;
import com.flightbooking.model.entity.Route;
import com.flightbooking.service.FlightService;
import com.flightbooking.service.serviceImpl.FlightServiceImpl;

@SpringBootTest
public class FlightControllerTest {

	@Autowired
	MockMvc  mockMvc;
	
	@MockBean
	FlightService service;
	
	private List<Flight> flight;
	private Route route;
	
	@Before(value = "")
	public void setUp() {
		this.route=new Route(1L,"bombay","delhi");
		this.flight=new ArrayList<>();
		this.flight.add(new Flight( 1L,"indigo","is3131",32,"monday",route));
		this.flight.add(new Flight( 2L,"AirIndia","is3133",32,"tuesday",route));
		this.flight.add(new Flight(3L,"indiaair","is3132",32,"wednesday",route));
		mockMvc=MockMvcBuilders.standaloneSetup(service).build();
	}
	
	@Test
	public void findTheFlight() {
		
		
		
	}
	
	
	
}
