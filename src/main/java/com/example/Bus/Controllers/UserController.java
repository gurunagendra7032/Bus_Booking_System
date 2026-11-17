package com.example.Bus.Controllers;

import com.example.Bus.Configuration.JwtUtility;
import com.example.Bus.DTO.LoginDTO;
import com.example.Bus.Entities.User;
import com.example.Bus.Repositories.UserRepo;
import com.example.Bus.Service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.net.Authenticator;

@CrossOrigin( origins = "http://localhost:5173")
@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtility jwtUtility;

    @PostMapping("/save/user")
    public User saveUser(@RequestBody User user){
        System.out.println(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return  userRepo.save(user);
    }

    @PostMapping("/user/login")
    public String getToken(@RequestBody LoginDTO loginDTO){
        System.out.println("inside the controller"+loginDTO.getUsername()+" "+loginDTO.getPassword());
        Authentication auth =authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getUsername(),loginDTO.password)
        );

        if(auth.isAuthenticated()){
           return jwtUtility.generateKey(loginDTO.getUsername());
        }else{
            return " Token is Not generated";
        }

    }





}
