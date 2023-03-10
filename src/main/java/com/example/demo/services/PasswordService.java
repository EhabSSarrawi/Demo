package com.example.demo.services;

import com.example.demo.models.User;

public interface PasswordService {

    String hashPassword(String password);

    boolean checkPass(User user, String password);
}
