package com.example.demo.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.example.demo.models.User;
import com.example.demo.services.UsersService;
@RestController
public class UsersController {

    private UsersService usersService;

    public UsersController(UsersService userService) {
        this.usersService =userService;
    }

    @RequestMapping("/users")
    public List<User> getAllUsers(){
        return usersService.getAll();
    }

    @PostMapping("/users")
    public String addOne(@RequestBody User user) {
        return usersService.addUser(user);
    }

    @GetMapping("/users/{id}")
    public String findUser(@PathVariable Integer userId){
        return usersService.findUser(userId);
    }

    @PutMapping("/users/{id}")
    public String updateUser(@RequestBody User user, @PathVariable Integer id) {
        return usersService.updateUser(user);
    }

    @DeleteMapping("/users")
    public String deleteUser(@PathVariable Integer userId){
        return usersService.deleteUser(userId);
    }
}