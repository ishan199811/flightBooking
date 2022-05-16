package com.flightbooking.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.model.entity.Airport;
import com.flightbooking.model.response.ResponseMessage;
import com.flightbooking.repository.AirportRepository;
import com.flightbooking.service.AirportService;

@Service
public class AirportServiceImpl implements AirportService {

	@Autowired
	AirportRepository airrepo;
	
	
	
	@Override
	public ResponseMessage saveair(Airport air) {
		airrepo.save(air);
		return ResponseMessage.builder().message("Airport have been saved").build();
	}



	@Override
	public ResponseMessage getAir() {
	List<Airport>	air=airrepo.findAll();
		
		return ResponseMessage.builder().message("All flights").data(air).build();
	}

}
