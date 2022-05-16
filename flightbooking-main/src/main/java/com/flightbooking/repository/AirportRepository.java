package com.flightbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightbooking.model.entity.Airport;

public interface AirportRepository extends JpaRepository<Airport , Long>{

	
	Airport findById(long airportId);
	
}
