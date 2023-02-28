package com.example.demo.controllers;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.models.User;
import com.example.demo.services.UsersService;

@AllArgsConstructor
@RestController
public class UsersController {

    private UsersService usersService;

    @RequestMapping("/users")
    public List<User> getAllUsers() {
        return usersService.getAll();
    }

    @PostMapping("/users")
    public User addOne(@RequestBody User user) {
        return usersService.addUser(user);
    }

    @GetMapping("/users/{id}")
    public User findUser(@PathVariable Integer id) {
        return usersService.findUser(id);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Integer id) {
        try {
            User updateUser = usersService.updateUser(id, user);
            return ResponseEntity.ok(updateUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<User> update1User(@RequestBody User user, @PathVariable Integer id) {
        try {
            User updateUser = usersService.updateUser(id, user);
            return ResponseEntity.ok(updateUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
         usersService.deleteUser(id);
    }
}