package com.flightbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightbooking.model.entity.Airport;
import com.flightbooking.service.AirportService;

@RestController
@RequestMapping("/airport")
public class AirportController {

	
	@Autowired
	AirportService airservice;
	
	
	
	
	@GetMapping("/get")
	public ResponseEntity<?> getAirport(){
		return ResponseEntity.ok(airservice.getAir());
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<?> saveAirport(@RequestBody Airport air){
		
		return ResponseEntity.ok(airservice.saveair(air));
	}
	
}
