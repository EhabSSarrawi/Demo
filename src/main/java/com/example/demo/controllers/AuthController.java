package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.services.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class AuthController {

    private UsersService usersService;

    @PostMapping("/signup")
    public String addUser(@RequestBody User user) {
        return usersService.addUser(user);
    }

}
