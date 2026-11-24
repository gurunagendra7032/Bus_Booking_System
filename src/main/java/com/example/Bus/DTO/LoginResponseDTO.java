package com.example.Bus.DTO;

import com.example.Bus.Entities.User;

public class LoginResponseDTO {

    public String Token;
    public User user;

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
