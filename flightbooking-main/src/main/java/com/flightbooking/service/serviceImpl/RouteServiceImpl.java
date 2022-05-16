package com.flightbooking.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.model.entity.Route;
import com.flightbooking.model.response.ResponseMessage;
import com.flightbooking.repository.RouteRepository;
import com.flightbooking.service.RouteService;

@Service
public class RouteServiceImpl implements RouteService {
	
	
	@Autowired
	RouteRepository routerepo;

	
	@Override
	public ResponseMessage saveRoute(Route route) {
			routerepo.save(route);	
		return ResponseMessage.builder().status("1").message("Route have been saved").build();
	}


	@Override
	public ResponseMessage getById(long id) {
		Route route=routerepo.findByRouteId(id);
		return ResponseMessage.builder().status("1").message("Route By Id").data(route).build();
	}

	
	
	
	
	
	

}
