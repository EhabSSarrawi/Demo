package com.example.demo.services;

import com.example.demo.models.User;
import java.util.List;

public interface UsersService {

    List<User> getAll();

    User addUser(User user);

    User findUser(Integer userId);

    List<User> findUserName(String userName);

    void deleteUser(Integer userId);

    User updateUser(Integer userId, User user);

    String checkUser(User user, String userName,  String password);

}