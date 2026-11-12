package com.example.Bus.Repositories;

import com.example.Bus.Entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepo extends JpaRepository<Bus, Integer> {
}
