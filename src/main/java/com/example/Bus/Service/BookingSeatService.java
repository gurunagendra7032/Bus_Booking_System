package com.example.Bus.Service;

import com.example.Bus.Entities.Seat;
import com.example.Bus.Repositories.BookingSeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingSeatService {

    @Autowired
     private SeatService seatService;

    @Autowired
    private BookingSeatRepo bookingSeatRepo;



    public List<Integer> getSeatIds(List<Integer> bookingIds) {

        return bookingSeatRepo.findByBooking_IdIn(bookingIds)
                .stream()
                .map(bs -> bs.getSeat().getSeatId())
                .toList();
    }
}
