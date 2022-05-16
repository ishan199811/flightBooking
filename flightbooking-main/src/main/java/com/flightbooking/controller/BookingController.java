package com.flightbooking.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.flightbooking.model.entity.Passenger;
import com.flightbooking.service.BookingService;
import com.flightbooking.service.PassengerService;

@RestController
@RequestMapping("/booking")
public class BookingController {

	
	@Autowired
	BookingService bookservice;
	
	@Autowired 
	PassengerService passService;
	
	
	@PostMapping("/save")
	public ResponseEntity<?> saveBooking(@RequestBody List<Passenger> pass , @RequestParam long id,@RequestParam String bookingDate) throws ParseException{
		
		
		return ResponseEntity.ok(bookservice.savePassenger(pass,id,bookingDate));
	}
	
	@GetMapping("/getbyid")
	public ResponseEntity<?> getBookingById(@RequestParam Long id){
		
		return ResponseEntity.ok(bookservice.getBookingById(id));
	}
	
}
