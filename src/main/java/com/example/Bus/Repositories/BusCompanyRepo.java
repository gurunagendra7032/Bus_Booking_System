package com.example.Bus.Repositories;

import com.example.Bus.Entities.BusCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusCompanyRepo extends JpaRepository<BusCompany, Integer> {
}
