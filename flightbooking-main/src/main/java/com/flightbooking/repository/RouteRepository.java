package com.flightbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightbooking.model.entity.Airport;
import com.flightbooking.model.entity.Route;

public interface RouteRepository extends JpaRepository<Route , Long> {

	
	
	Route findBySourceAndDestination(String source, String destination);
Route findByRouteId(long routeId);
List<Route> findBySource(String source);
Route findFlightBySourceAndDestination(String source, String destination);
List<Route> findByDestination(String destination);
	
}
