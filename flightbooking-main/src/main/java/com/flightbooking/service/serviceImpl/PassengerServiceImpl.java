package com.flightbooking.service.serviceImpl;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.model.dto.PaasengerDto;
import com.flightbooking.model.entity.Flight;
import com.flightbooking.model.entity.Passenger;
import com.flightbooking.model.response.ResponseMessage;
import com.flightbooking.repository.FlightRepository;
import com.flightbooking.repository.PassengerRepository;
import com.flightbooking.service.PassengerService;

@Service
public class PassengerServiceImpl implements PassengerService{

@Autowired
PassengerRepository passRepo;

@Autowired
FlightRepository flyrepo;


//Saving the passenger detail
@Override
public ResponseMessage savePassenger(List<Passenger> passenger) {
			passRepo.saveAll(passenger);
			return null;
	
}

//Findind Seat available or not for the flight  
@Override
public ResponseMessage findBydepartureDateAndFlight(PaasengerDto passengerDto) {

	
	String date=passengerDto.getDate();
	
	Flight flight1=flyrepo.findById(passengerDto.getFlightId());
	List<Passenger> pass=passRepo.findBydepartureDateAndFlight(date, flight1);
			int totalSeatLeft=flight1.getSeatCapacity()-pass.size();
			
			if(flight1.getSeatCapacity()==pass.size()) {
				return ResponseMessage.builder().status("1").data(totalSeatLeft).message("Seat Not Available").build();	
			}
			
				return ResponseMessage.builder().status("1").data(totalSeatLeft+":Seats are available").message("Seats Are Available").build();
}
}
