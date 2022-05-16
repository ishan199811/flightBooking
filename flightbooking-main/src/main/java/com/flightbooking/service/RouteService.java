package com.flightbooking.service;

import com.flightbooking.model.entity.Route;
import com.flightbooking.model.response.ResponseMessage;

public interface RouteService {
	
	
	
	ResponseMessage saveRoute(Route route);

	ResponseMessage getById(long id);
}
