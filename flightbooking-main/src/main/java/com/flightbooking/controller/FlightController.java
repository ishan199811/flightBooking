package com.flightbooking.controller;

import java.text.ParseException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightbooking.api.data.FlightSearch1;
import com.flightbooking.model.dto.FlightDto;
import com.flightbooking.model.dto.PaasengerDto;

import com.flightbooking.model.response.ResponseMessage;
import com.flightbooking.service.FlightService;
import com.flightbooking.service.PassengerService;


import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/flight")
public class FlightController {
	
	@Autowired
	FlightService flyservice;
	
	@Autowired
	PassengerService passengerService;
	
	
	

	/* geting flight detail between source and destination by particular date 
	  */
	@GetMapping("/get")
	public ResponseEntity<ResponseMessage> getflightByRoute(@Valid @RequestBody FlightSearch1 search) throws ParseException {
	
	return ResponseEntity.ok(flyservice.getflightbyroute(search));
	}
	
	
	/* geeting conecting flight between source and destination 
	*/
	@GetMapping("/getc")
	public ResponseEntity<ResponseMessage> getflightByConnectingRoute(@Valid @RequestBody FlightSearch1 search) throws ParseException {
   
	return ResponseEntity.ok(flyservice.getConnectingFlight(search));
	}
	
	
	/* saving flight detail 
	 */
	@PostMapping("/save")
	public ResponseEntity<ResponseMessage> saveFlight(@RequestBody FlightDto flight){
		
		return ResponseEntity.ok(flyservice.saveFlight(flight));
	}
	
	@GetMapping("/getseat")
	public ResponseEntity<ResponseMessage> checkingaAvailability(@RequestBody PaasengerDto passenger) throws ParseException {
    log.info(  " source  airport  destination airport  "+ passenger);
	return ResponseEntity.ok(passengerService.findBydepartureDateAndFlight( passenger));
	}
	
	

}
