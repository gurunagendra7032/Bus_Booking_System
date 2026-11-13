package com.example.Bus.Service;

import com.example.Bus.Repositories.TripRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatService {

    @Autowired
    private TripRepo tripRepo;


}
