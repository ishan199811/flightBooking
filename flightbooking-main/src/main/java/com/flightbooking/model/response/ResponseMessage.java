package com.flightbooking.model.response;





import lombok.Builder;
import lombok.Data;

@Data
  @Builder
public class ResponseMessage  {
	
	
	

	private String message;
	
 private String status;
	
private  Object data;

}
