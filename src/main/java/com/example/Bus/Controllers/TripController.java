package com.example.Bus.Controllers;

import com.example.Bus.DTO.TripDetailsDto;
import com.example.Bus.DTO.TripServiceDTO;
import com.example.Bus.Entities.Bus;
import com.example.Bus.Entities.BusCompany;
import com.example.Bus.Entities.Trip;
import com.example.Bus.Repositories.BusCompanyRepo;
import com.example.Bus.Repositories.BusRepo;
import com.example.Bus.Repositories.TripRepo;
import com.example.Bus.Service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class TripController {

    @Autowired
    private TripRepo tripRepo;

    @Autowired
    private TripService tripService;

    @Autowired
    private BusRepo busRepo;

    @Autowired
    private BusCompanyRepo busCompanyRepo;

    @PostMapping("/admin/save/tripDetails")
    public Trip saveTrip(@RequestBody Trip trip){

        Integer busId = trip.getBus().getBusId();
        Integer companyId = trip.getBusCompany().getId();

        Bus bus = busRepo.findById(busId)
                .orElseThrow(() -> new RuntimeException("Bus not found"));

        BusCompany company = busCompanyRepo.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Company not found"));

        trip.setBusCompany(company);
        trip.setBus(bus);
        return tripRepo.save(trip);
    }


    @GetMapping("/get/buses/{from}/{to}/{date}")
    public List<TripDetailsDto> getSeats(@PathVariable String from , @PathVariable String to , @PathVariable LocalDate date){
        return tripService.findBusCompanies(from,to,date);
    }

    @GetMapping("/get/all/trips")
    public List<Trip> getTrip(){
        return tripRepo.findAll();
    }


}
