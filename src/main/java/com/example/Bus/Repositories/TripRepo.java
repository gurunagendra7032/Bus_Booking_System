package com.example.Bus.Repositories;

import com.example.Bus.Entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepo extends JpaRepository<Trip,Integer> {
}
