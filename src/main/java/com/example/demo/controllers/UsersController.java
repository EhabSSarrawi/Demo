package com.example.demo.controllers;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.example.demo.models.AppUser;
import com.example.demo.services.UsersService;

@AllArgsConstructor
@RestController
public class UsersController {

    private UsersService usersService;

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("/users/{id}")
    public AppUser findUser(@PathVariable int id) {
        return usersService.findUser(id);
    }

    @PreAuthorize("hasAuthority('admin') or hasAuthority('user')")
    @PutMapping("/users")
    public AppUser updateUser(@RequestBody AppUser user) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return usersService.updateUser(user, userDetails.getUsername());
    }

    @PreAuthorize("hasAuthority('admin') or hasAuthority('user')")
    @DeleteMapping("/users")
    public void deleteUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        usersService.deleteUser(userDetails.getUsername());
    }
}