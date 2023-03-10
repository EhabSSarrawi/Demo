package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.services.UsersService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class AuthController {

    private UsersService usersService;

    @PostMapping("/signup")
    public User addUser(@RequestBody User user) {
        return usersService.addUser(user);
    }

    @PostMapping("/signin")
    public String checkUser(@RequestBody User user) {
        System.out.println(user + user.getUserName()+ user.getPassword());
        return usersService.checkUser(user, user.getUserName(), user.getPassword());
    }

}
