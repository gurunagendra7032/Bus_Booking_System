package com.example.Bus.Service;

import com.example.Bus.DTO.TripDetailsDto;
import com.example.Bus.DTO.TripServiceDTO;
import com.example.Bus.Entities.Bus;
import com.example.Bus.Entities.BusCompany;
import com.example.Bus.Entities.Trip;
import com.example.Bus.Repositories.BusCompanyRepo;
import com.example.Bus.Repositories.BusRepo;
import com.example.Bus.Repositories.TripRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TripService {

    @Autowired
    private TripRepo tripRepo;

    @Autowired
    private BusCompanyRepo busCompanyRepo;

    @Autowired
    private BusRepo busRepo;

    public List<TripDetailsDto> findBusCompanies(String from, String to, LocalDate date) {

        List<Trip> trips = tripRepo.findByFromDestinationAndToDestinationAndTripDate(from, to,date);

        List<TripDetailsDto> result = new ArrayList<>();

        for (Trip t : trips) {
            TripDetailsDto tripDetailsDto = new TripDetailsDto();
            BusCompany busCompany = t.getBusCompany();
            Bus bus= t.getBus();
            tripDetailsDto.setBusCompany(busCompany);
            tripDetailsDto.setBusId(bus);
            tripDetailsDto.setTripId(t.getTripId());
            result.add(tripDetailsDto);
        }

        return result;
    }
}