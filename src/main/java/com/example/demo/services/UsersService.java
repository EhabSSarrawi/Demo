package com.example.demo.services;

import com.example.demo.models.User;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.UsersRepository;
import java.util.List;

@Service
public class UsersService {

    private UsersRepository userRepository;

    public UsersService(UsersRepository usersRepository) {
        this.userRepository =usersRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public String addUser(User user) {
        userRepository.save(user);
        return "success";
    }

    public String findUser(Integer userId){
         userRepository.findById(userId);
         return "success";
    }

    public String deleteUser(Integer userId){
        userRepository.deleteById(userId);
        return "success";
    }

    public String updateUser(User user){
        userRepository.save(user);
        return "success";
    }

}