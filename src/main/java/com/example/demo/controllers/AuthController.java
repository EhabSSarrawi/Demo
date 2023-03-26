package com.example.demo.controllers;

import com.example.demo.models.AppUser;
import com.example.demo.services.JwtService;
import com.example.demo.services.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class AuthController {

    private UsersService usersService;

    private AuthenticationManager authenticationManager;

    private JwtService jwtService;

    @PostMapping("/auth/signup")
    public AppUser addUser(@RequestBody AppUser user) {
        return usersService.addUser(user);
    }

    @PostMapping("/auth/signin")
    public String checkUser(@RequestBody AppUser user) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        return jwtService.generateJwtToken(user.getEmail());
    }

}
