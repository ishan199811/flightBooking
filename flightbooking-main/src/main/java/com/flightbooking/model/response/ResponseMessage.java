package com.flightbooking.model.response;





import lombok.Builder;
import lombok.Data;

@Data
  @Builder
public class ResponseMessage  {
	
	
	

	public String message;
	
public 	String status;
	
public	Object data;

}
