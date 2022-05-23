package com.flightbooking.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.flightbooking.model.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking , Long> {


}
