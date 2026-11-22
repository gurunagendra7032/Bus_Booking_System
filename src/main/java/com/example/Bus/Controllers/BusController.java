package com.example.Bus.Controllers;

import com.example.Bus.Entities.Bus;
import com.example.Bus.Repositories.BusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class BusController {

    @Autowired
     private BusRepo busRepo;

    @PostMapping("/save/bus/details")
    public Bus saveBusDetails(@RequestBody Bus bus){
        return busRepo.save(bus);
    }

    @GetMapping("/get/buses")
    public List<Bus> getAllBuses(Principal principal){

        return busRepo.findAll();
    }


}
