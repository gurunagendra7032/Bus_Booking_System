package com.example.Bus.Service;

import com.example.Bus.Entities.Booking;
import com.example.Bus.Entities.Seat;
import com.example.Bus.Entities.Trip;
import com.example.Bus.Repositories.BookingRepo;
import com.example.Bus.Repositories.TripRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatService {

    @Autowired
    private TripRepo tripRepo;
    @Autowired
    private BookingRepo bookingRepo;

    public List<Integer> getSeats(Integer id){

        return bookingRepo.findByTrip_TripId(id)
                .stream()
                .map(Booking::getId)
                .toList();
    }



}
