package com.flightbooking.service.serviceImpl;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.api.data.FlightSearch1;
import com.flightbooking.model.dto.FlightDto;
import com.flightbooking.model.entity.Flight;
import com.flightbooking.model.entity.Route;
import com.flightbooking.model.response.ResponseMessage;
import com.flightbooking.repository.FlightRepository;
import com.flightbooking.repository.PassengerRepository;
import com.flightbooking.repository.RouteRepository;
import com.flightbooking.service.FlightService;

import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class FlightServiceImpl implements FlightService{
	
	@Autowired
	FlightRepository flyrepo;

	@Autowired 
	RouteRepository routeRepo;
	
	@Autowired
	PassengerRepository passRepo;
	
	 
	
	//getting flight by source and destination on particular date
	@Override
	public ResponseMessage getflightbyroute(FlightSearch1 search) throws ParseException {
	
		//getting search fields from FlightSearch1
		String source=search.getSource();
		String destination=search.getDestination();
		log.info(source+"--------------------------------"+destination);
	
		//getting route by Source and Destination
		Route r=routeRepo.findFlightBySourceAndDestination(source, destination);
		
		
		//converting date into week day
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", java.util.Locale.ENGLISH);
		Date myDate = sdf.parse(search.getDate());
		sdf.applyPattern("EEEE");
		String day = sdf.format(myDate);
		
		//findind Flights with the route
		List<Flight> flight11=flyrepo.findFlightByRouteId(r);
		log.info(day+"--------------------------------");

		//filtering flights for the given date
		  List<Flight> tempList = flight11.stream()
	            .filter(e ->e.getDay().contains(day))
	              .collect(Collectors.toList());

		  //checking if pflight is present or not
		  if(tempList.isEmpty()) {  
	
		
		return ResponseMessage.builder().status("201")
				.message(" There is no direct flight from :"+ source+ " to: " +destination +" on "+myDate+","+day)
				.build();
			}
		

		return ResponseMessage.builder().status("201").message(" flight between airports on :"+day+ " " +search.getDate())
			.data(tempList).build();
	}
	
	
//getting connecting flight between source and destination
	@Override
	public ResponseMessage getConnectingFlight(FlightSearch1 search) throws ParseException {
		
		String source=search.getSource();
		String destination=search.getDestination();
	
		//converting date into week day
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", java.util.Locale.ENGLISH);
				
		
		 sdf.applyPattern("EEEE");
				
		
				//getting data by source
				List<Route> route=routeRepo.findBySource(source);
			
			//geetind route by destination
			List<Route> route1=routeRepo.findByDestination(destination);
			
			//Filtering Route 
			Set<String> exclusions = route.stream()
				    .map(Route::getDestination)
				    .collect(Collectors.toSet());
			
			List<Route> filtered = route1.stream()
				    .filter(p -> exclusions.contains(p.getSource()))
				    .collect(Collectors.toList());
		
			//Filtering route 1 
			//route destination = route 1 source
			Set<String> exclusion = route1.stream()
			    .map(Route::getSource)
				    .collect(Collectors.toSet());
			
			List<Route> filteredRoute = route.stream()
				    .filter(p -> exclusion.contains(p.getDestination()))
				    .collect(Collectors.toList());
			
			filteredRoute.addAll(filtered);
	
			//geeting flight by routes
			List<Flight> connectingFlight=flyrepo.findByRouteId(filteredRoute);
			
			return ResponseMessage.builder().status("201").data(connectingFlight)
					  .message("There is no direct flight:"+search.getDate()).build();
	}
	
	
	//this method is saving flight
	@Override
	public ResponseMessage saveFlight(FlightDto flight) {
		log.info(flight + ".........................................");
		Flight fl=new Flight();
		fl.setFlightId(flight.getFlightId());
		fl.setFlightName(flight.getFlightName());
		fl.setFlightModel(flight.getFlightModel());
		fl.setSeatCapacity(flight.getSeatCapacity());
		fl.setDay(flight.getDay());
		Long id=flight.getRouteId();
		Route route=routeRepo.findByRouteId(id);
		fl.setRouteId(route);
		flyrepo.save(fl);
		
		return ResponseMessage.builder().status("1").message("Flight have Been saved").build();
	}

	@Override
	public ResponseMessage getAllFlight() {
		
		List<Flight> flight=flyrepo.findAll();
		
		return ResponseMessage.builder().status("1").data(flight).message("Flight have Been saved").build();
		}
}
