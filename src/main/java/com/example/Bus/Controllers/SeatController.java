package com.example.Bus.Controllers;

import com.example.Bus.Entities.Seat;
import com.example.Bus.Repositories.SeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SeatController {

    @Autowired
    private SeatRepo seatRepo;

    @PostMapping("/save/seat")
    public Seat saveSeatDetails(@RequestBody Seat seat){
        return seatRepo.save(seat);
    }

    @GetMapping("/get/{id}/seats")
    public List<Seat> getSeats(@PathVariable int id){
        return seatRepo. findByBusBusId(id);
    }

}
