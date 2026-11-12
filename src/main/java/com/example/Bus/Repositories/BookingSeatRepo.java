package com.example.Bus.Repositories;

import com.example.Bus.Entities.BookingSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingSeatRepo extends JpaRepository<BookingSeat,Integer> {
}
