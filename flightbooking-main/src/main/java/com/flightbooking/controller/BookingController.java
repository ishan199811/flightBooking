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

import com.flightbooking.model.dto.BookingDto;
import com.flightbooking.model.entity.Passenger;
import com.flightbooking.model.response.ResponseMessage;
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
	public ResponseEntity<ResponseMessage> saveBooking(@RequestBody BookingDto bookingDto) throws ParseException{
		
		
		return ResponseEntity.ok(bookservice.savePassenger(bookingDto));
	}
	
	@GetMapping("/getbyid")
	public ResponseEntity<ResponseMessage> getBookingById(@RequestParam Long id){
		
		return ResponseEntity.ok(bookservice.getBookingById(id));
	}
	
}
