package com.flightbooking.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;


import com.flightbooking.model.entity.Booking;
import com.flightbooking.model.entity.Flight;
import com.flightbooking.model.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger , Long>{

	List<Passenger> findBydepartureDateAndFlight(String date,Flight flight);

	List<Passenger> findByBookingId(Booking booking);

}
