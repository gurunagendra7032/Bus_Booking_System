package com.example.Bus.Controllers;

import com.example.Bus.Entities.User;
import com.example.Bus.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/save/user")
    public User saveUser(@RequestBody User user){
      return  userRepo.save(user);
    }


}
