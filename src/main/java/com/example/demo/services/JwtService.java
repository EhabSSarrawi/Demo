package com.example.demo.services;

public interface JwtService {

    String generateJwtToken(int id);

    boolean validToken(String authToken);
}
