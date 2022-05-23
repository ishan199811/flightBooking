package com.flightbooking.api.data;





import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import lombok.Data;

@Data
public class FlightSearch1 {
	


@NotEmpty(message="Source Cannopt be empty")
//@Size(min = 4, message = "Source should have at least 4 characters")
private String source;
@NotEmpty(message="Destination Cannopt be empty")
 private	 String destination;

private String date;

public FlightSearch1() {
}

public FlightSearch1(String source, String destination, String date) {
this.source=source;
this.destination=destination;
this.date=date;
}
}
