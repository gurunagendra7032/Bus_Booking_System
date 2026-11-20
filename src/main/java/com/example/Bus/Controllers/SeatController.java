package com.example.Bus.Controllers;

import com.example.Bus.Entities.Bus;
import com.example.Bus.Entities.Seat;
import com.example.Bus.Entities.Trip;
import com.example.Bus.Repositories.BusRepo;
import com.example.Bus.Repositories.SeatRepo;
import com.example.Bus.Repositories.TripRepo;
import com.example.Bus.Service.BookingSeatService;
import com.example.Bus.Service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class SeatController {

    @Autowired
    private SeatRepo seatRepo;

    @Autowired
    private TripRepo tripRepo;

    @Autowired
    private SeatService seatService;

    @Autowired
    private BookingSeatService bookingSeatService;

    @Autowired
    private BusRepo busRepo;

    @PostMapping("/save/seat")
    public Seat saveSeatDetails(@RequestBody Seat seat){
        return seatRepo.save(seat);
    }


    @GetMapping("/get/{id}/seats")
    public List<Seat> getSeats(@PathVariable Integer id) {

        // Get Booking IDs for this Trip
        List<Integer> bookedIds = seatService.getSeats(id);

        // Get Seat IDs associated with those bookings
        List<Integer> bookedSeats = bookingSeatService.getSeatIds(bookedIds);

        System.out.println("Booked Seat IDs: " + bookedSeats);

        // Get Trip
        Trip trip = tripRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Trip not found"));

        // Get Bus ID
        Integer busId = trip.getBus().getBusId();

        // Get all seats belonging to this Bus
        List<Seat> seats = seatRepo.findByBus_BusId(busId);

        // Filter available seats
        List<Seat> availableSeats = seats.stream()
                .filter(seat -> !bookedSeats.contains(seat.getSeatId()))
                .toList();

        return availableSeats;
    }




    @GetMapping("/get/name")
    public String hello(){
        return "Hi Guru Nagendra";
    }

    @GetMapping("/get/value")
    public ResponseEntity<String> getvalue(){
        return ResponseEntity.ok("Hi I am Back");
    }


}
