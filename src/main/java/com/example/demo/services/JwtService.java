package com.example.demo.services;

public interface JwtService {

    String generateJwtToken(String email);

    boolean validToken(String authToken);

    String getEmailFromJwtToken(String jwtToken);
}
