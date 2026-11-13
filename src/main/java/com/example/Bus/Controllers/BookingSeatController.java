package com.example.Bus.Controllers;

import com.example.Bus.Repositories.BookingSeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingSeatController {

    @Autowired
    private BookingSeatRepo bookingSeatRepo;


}
