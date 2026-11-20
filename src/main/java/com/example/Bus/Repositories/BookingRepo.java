package com.example.Bus.Repositories;

import com.example.Bus.Entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepo extends JpaRepository<Booking,Integer> {

    List<Booking> findByTrip_TripId(Integer tripId);
}
