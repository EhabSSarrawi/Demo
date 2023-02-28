package com.example.demo.services;

import com.example.demo.models.User;
import java.util.List;

public interface UsersService {

    public List<User> getAll();

    public User addUser(User user);

    public User findUser(Integer userId);

    public void deleteUser(Integer userId);

    public User updateUser(Integer userId, User user) throws Exception;

    public User update1User(Integer userId, User user) throws Exception;

}