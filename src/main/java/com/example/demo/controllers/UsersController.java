package com.example.demo.controllers;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.demo.models.User;
import com.example.demo.services.UsersService;
import com.example.demo.repositories.UsersRepository;

@AllArgsConstructor
@RestController
public class UsersController {

    private UsersService usersService;

    private UsersRepository usersRepository;

    @RequestMapping("/users")
    public List<User> getAllUsers() {
        return usersService.getAll();
    }

    @GetMapping("/users/{id}")
    public User findUser(@PathVariable Integer id) {
        return usersService.findUser(id);
    }

    @GetMapping("/users/name/{userName}")
    public List<User> findUserName(@PathVariable String userName) {
        return usersRepository.findByUserName(userName);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Integer id) {
           return usersService.updateUser(id, user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        usersService.deleteUser(id);
    }
}