package com.example.demo.services;

import com.example.demo.models.AppUser;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UsersService extends UserDetailsService {

    AppUser addUser(AppUser user);

    AppUser findUser(int id);

    void deleteUser(String email);

    AppUser updateUser(AppUser appUser, String email);

}