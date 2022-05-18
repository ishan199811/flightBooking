package com.flightbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.flightbooking.model.entity.Flight;
import com.flightbooking.model.entity.Route;


public interface FlightRepository extends JpaRepository<Flight , Long> {
	
	List<Flight> findFlightByRouteIdAndDay(Route routeId ,String day);
	
	List<Flight> findByDay(String day);
	
	Flight findById(long id);
	
	@Query("SELECT f FROM Flight f WHERE CONCAT(f.routeId.source) LIKE %?1%")
	Flight findBySource(String source );
	
	@Query("SELECT f FROM Flight f WHERE CONCAT(f.routeId.destination) LIKE %?1%")
	Flight findByDestination(String destination );
	
	List<Flight> findFlightByRouteId(Route r);
	
	@Query(
	        "SELECT CASE WHEN COUNT(s) > 0 THEN TRUE ELSE FALSE END FROM Flight s WHERE s.flightId = ?1")
	    Boolean
	    isFlightExitsById(long id);

}
