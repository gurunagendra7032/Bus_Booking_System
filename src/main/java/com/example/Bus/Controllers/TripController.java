package com.example.Bus.Controllers;

import com.example.Bus.DTO.TripServiceDTO;
import com.example.Bus.Entities.Bus;
import com.example.Bus.Entities.Trip;
import com.example.Bus.Repositories.TripRepo;
import com.example.Bus.Service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class TripController {

    @Autowired
    private TripRepo tripRepo;

    @Autowired
    private TripService tripService;

    @PostMapping("/save/tripDetails")
    public Trip saveTrip(@RequestBody Trip trip){
        return tripRepo.save(trip);
    }


    @GetMapping("/get/buses/{from}/{to}")
    public List<TripServiceDTO> getSeats(@PathVariable String from , @PathVariable String to){
        return tripService.getTotalSeats(from,to);
    }

    @GetMapping("/get/all/trips")
    public List<Trip> getTrip(){
        return tripRepo.findAll();
    }


}
