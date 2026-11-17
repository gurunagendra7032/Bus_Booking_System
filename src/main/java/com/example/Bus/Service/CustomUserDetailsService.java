package com.example.Bus.Service;

import com.example.Bus.Entities.User;
import com.example.Bus.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       System.out.println("Username"+username);
        User user= userRepo.findByUserName(username);
        System.out.println(user.getUserName());
        return new customUserDetails(user);
    }
}
