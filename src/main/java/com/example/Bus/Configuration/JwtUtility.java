package com.example.Bus.Configuration;

import com.example.Bus.Service.customUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import tools.jackson.databind.util.ClassUtil;

import javax.crypto.SecretKey;
import java.util.Date;
@Component
public class JwtUtility {

    private final SecretKey secretKey;



    public JwtUtility(@Value("${jwt.secret}") String secret) {
        this.secretKey = Keys.hmacShaKeyFor(
                Decoders.BASE64.decode(secret)
        );
    }



    public String generateKey( String username){
       return   Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(secretKey)
                .compact();
    }

    private Claims extractClaims(String token) {

        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String extractUsername(String token){
      return extractClaims(token).getSubject();
    }

    public boolean validToken(String token, String username) {
        return username.equals(extractUsername(username)) && !isTokenValid(token);
    }

    public boolean isTokenValid(String token){
        return extractClaims(token).getExpiration().before(new Date());
    }

}
