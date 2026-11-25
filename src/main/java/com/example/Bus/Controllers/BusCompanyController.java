package com.example.Bus.Controllers;

import com.example.Bus.Entities.BusCompany;
import com.example.Bus.Repositories.BusCompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class BusCompanyController {

    @Autowired
    private BusCompanyRepo busCompanyRepo;

    @PostMapping("/admin/save/buscompany")
    public BusCompany saveComapnies(@RequestBody BusCompany busCompany){
        return busCompanyRepo.save(busCompany);
    }

    @GetMapping("/admin/get/all/companies")
    public List<BusCompany> getAllBusCompanies(){
       return busCompanyRepo.findAll();
    }

}