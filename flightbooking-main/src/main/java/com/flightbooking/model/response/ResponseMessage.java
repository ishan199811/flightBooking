package com.flightbooking.model.response;

import java.util.List;

import com.flightbooking.model.entity.Flight;

import lombok.Builder;
import lombok.Data;

@Data
  @Builder
public class ResponseMessage  {
	
	
	

	public String message;
	
public 	String status;
	
public	Object data;

}
