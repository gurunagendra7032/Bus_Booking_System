package com.example.Bus.Repositories;

import com.example.Bus.Entities.TripSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripScheduleRepo extends JpaRepository<TripSchedule,Integer> {

}
