package com.example.Bus.Service;

import com.example.Bus.Entities.Booking;
import com.example.Bus.Entities.BookingSeat;
import com.example.Bus.Entities.Seat;
import com.example.Bus.Entities.Trip;
import com.example.Bus.Repositories.BookingRepo;
import com.example.Bus.Repositories.TripRepo;
import com.example.Bus.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class BookingService {

    @Autowired
    private TripRepo tripRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BookingRepo bookingRepo;




}
