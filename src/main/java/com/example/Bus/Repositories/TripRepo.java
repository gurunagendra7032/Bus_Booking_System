package com.example.Bus.Repositories;

import com.example.Bus.Entities.Bus;
import com.example.Bus.Entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripRepo extends JpaRepository<Trip,Integer> {
    List<Trip> findByFromDestinationAndToDestination(String from,String to);
}
