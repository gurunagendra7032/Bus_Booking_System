package com.example.Bus.Service;

import com.example.Bus.DTO.TripServiceDTO;
import com.example.Bus.Entities.Bus;
import com.example.Bus.Entities.Trip;
import com.example.Bus.Repositories.BusRepo;
import com.example.Bus.Repositories.TripRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TripService {

    @Autowired
    private TripRepo tripRepo;

    public List<TripServiceDTO> getTotalSeats(String from, String to) {

        List<Trip> trips = tripRepo.findByFromDestinationAndToDestination(from, to);

        List<TripServiceDTO> result = new ArrayList<>();

        for (Trip t : trips) {

            TripServiceDTO dto = new TripServiceDTO();

            dto.setTripId(t.getTripId());
            dto.setBusId(t.getBus().getBusId());
            dto.setBusNumber(t.getBus().getBusNumber());
            dto.setTotalSeats(t.getBus().getTotalSeats());

            result.add(dto);
        }

        return result;
    }
}