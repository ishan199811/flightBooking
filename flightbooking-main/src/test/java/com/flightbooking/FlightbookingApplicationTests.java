package com.flightbooking;






import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.DynamicTest.stream;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.flightbooking.model.entity.Flight;
import com.flightbooking.model.entity.Route;
import com.flightbooking.repository.FlightRepository;
import com.flightbooking.service.Calculator;
import com.flightbooking.service.FlightService;


@SpringBootTest
class FlightbookingApplicationTests {

	
	
	/*
	 * @Test public void getFlightTest() throws ParseException {
	 * 
	 * Route r=new Route(); when(flightrepo.findFlightByRouteIdAndDay(new Route(),
	 * "Monday")).thenReturn((List<Flight>) Stream.of(new
	 * Flight("air in ","4s31",20,"Monday",r) , new
	 * Flight("air in ","4s31",20,"Monday",r))); assertEquals(2,
	 * flightservice.getflightbyroute(null));
	 * 
	 * 
	 * 
	 * }
	 */
	
	
	
	
 Calculator calculator=new Calculator();
	
	@Test
	void testSum() {
		
		//expected
		int expectResult=17;
	//actual
	int actualResult=calculator.doSum(11, 1, 5);
	
	
	assertEquals(expectResult, actualResult);
	
	
	
	}
	
	@Test
	void testProduct() {
		
		//expected
		int expectResult=10;
	//actual
	int actualResult=calculator.doMult(5, 2);
	
	
	assertEquals(10, actualResult);
	
	
	
	}
	
	
	
	
}
