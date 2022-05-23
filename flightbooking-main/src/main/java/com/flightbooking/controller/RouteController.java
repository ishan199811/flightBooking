package com.flightbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flightbooking.model.entity.Route;
import com.flightbooking.model.response.ResponseMessage;
import com.flightbooking.service.RouteService;

@RestController
@RequestMapping("/route")
public class RouteController {

	@Autowired
	RouteService routeservice;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseMessage> saveRoute(@RequestBody Route route){
		
		return ResponseEntity.ok(routeservice.saveRoute(route));
	}
	
	@GetMapping("/getroutebyid")
	public ResponseEntity<ResponseMessage> getRoute(@RequestParam long id){
		
		return ResponseEntity.ok(routeservice.getById(id));
		
		
	}
	
}
