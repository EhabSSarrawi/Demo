package com.example.demo.services.userserviceimp;

import com.example.demo.models.User;
import com.example.demo.repositories.UsersRepository;
import com.example.demo.services.JwtService;
import com.example.demo.services.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImp implements UsersService {

    private UsersRepository userRepository;

    private JwtService jwtService;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public String addUser(User user) {
         userRepository.save(user);
         return jwtService.generateJwtToken(user.getId());

    }

    public User findUser(Integer userId) {
        Optional user =  userRepository.findById(userId);
        return (User) user.get();
    }
    
    public List<User> findUserName(String userName, int id){
        List<User> user = userRepository.findByUserName(userName);
        return user;
    }

    public void deleteUser(Integer userId) {
        userRepository.findById(userId).get();
        userRepository.deleteById(userId);
    }

    public User updateUser(Integer userId, User user) {
        User existingUser = userRepository.findById(userId).get();
        existingUser.setUserName(user.getUserName());
        return userRepository.save(existingUser);
    }

}