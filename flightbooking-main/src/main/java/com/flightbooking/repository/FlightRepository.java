package com.flightbooking.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flightbooking.model.entity.Flight;
import com.flightbooking.model.entity.Route;


public interface FlightRepository extends JpaRepository<Flight , Long> {
	
	List<Flight> findFlightByRouteIdAndDay(Route routeId ,String day);
	
	List<Flight> findByDay(String day);
	
	Flight findById(long id);
	
	List<Flight> findFlightByRouteId(Route r);
	

	
	@Query("select r from Flight r where r.routeId in :routeId" )
	  List<Flight> findByRouteId(@Param("routeId") List<Route> routeId);

}
