package com.example.Bus.Repositories;

import com.example.Bus.Entities.BookingSeat;
import com.example.Bus.Entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingSeatRepo extends JpaRepository<BookingSeat,Integer> {

    List<BookingSeat> findByBooking_IdIn(List<Integer> bookingIds);
}
