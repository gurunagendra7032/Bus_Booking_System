package com.example.Bus.Repositories;

import com.example.Bus.Entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusRepo extends JpaRepository<Bus, Integer> {
    List<Bus> findByBusCompany_Id(int id);
}
