package com.example.Bus.Repositories;

import com.example.Bus.Entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepo extends JpaRepository<Seat,Integer> {
}
