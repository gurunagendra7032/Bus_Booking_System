package com.example.Bus.Controllers;

import com.example.Bus.Entities.BusCompany;
import com.example.Bus.Repositories.BusCompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusCompanyController {

    @Autowired
    private BusCompanyRepo busCompanyRepo;

    @PostMapping("/save/buscompany")
    public BusCompany saveComapnies(@RequestBody BusCompany busCompany){
        return busCompanyRepo.save(busCompany);
    }

}
