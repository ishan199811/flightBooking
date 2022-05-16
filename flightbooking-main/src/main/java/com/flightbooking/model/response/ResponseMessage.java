package com.flightbooking.model.response;

import java.util.List;

import com.flightbooking.model.entity.Flight;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseMessage  {
	
	String message;
	
	String status;
	
	Object data;

}
