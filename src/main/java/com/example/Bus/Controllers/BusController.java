package com.example.Bus.Controllers;

import com.example.Bus.Entities.Bus;
import com.example.Bus.Repositories.BusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class BusController {

    @Autowired
     private BusRepo busRepo;

    @PostMapping("/admin/save/bus/details")
    public Bus saveBusDetails(@RequestBody Bus bus){
        return busRepo.save(bus);
    }

    @GetMapping("/admin/get/{id}/buses")
    public List<Bus> getAllBuses(@PathVariable int id){

        return busRepo.findByBusCompany_Id(id);
    }


}
