package com.example.Bus.Repositories;

import com.example.Bus.Entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepo extends JpaRepository<Seat,Integer> {

    List<Seat>  findByBusBusId(int id);
}
