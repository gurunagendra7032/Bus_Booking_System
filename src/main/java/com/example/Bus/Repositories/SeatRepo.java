package com.example.Bus.Repositories;

import com.example.Bus.Entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeatRepo extends JpaRepository<Seat,Integer> {

    List<Seat> findByBus_BusId(Integer busId);

    Seat findBySeatNumber(int val);
}
