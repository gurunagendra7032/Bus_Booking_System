package com.example.Bus.Service;

import com.example.Bus.Entities.User;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class customUserDetails implements UserDetails {

    private User user;

    public customUserDetails(User user){
        this.user=user;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public @Nullable String getPassword() {
        System.out.println("inside password : "+user.getPassword());
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        System.out.println("inside username : "+user.getUserName());
        return user.getUserName();
    }
}
