package com.example.demo.services.UserServiceImplementation;

import com.example.demo.models.User;
import com.example.demo.repositories.UsersRepository;
import com.example.demo.services.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImplementation implements UsersService {

    private UsersRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User findUser(Integer userId) {
        Optional user=  userRepository.findById(userId);
        if(user.isPresent()) {
            return (User) user.get();
        }
        else {
            return null;
        }
    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    public User updateUser(Integer userId, User user) throws Exception {
        User existingUser = userRepository.findById(userId).orElseThrow(() -> new Exception("User not found"));
        existingUser.setUserName(user.getUserName());
        return userRepository.save(existingUser);
    }

    public User update1User(Integer userId, User user) throws Exception {
        User existUser = userRepository.findById(userId).orElseThrow(()-> new Exception("User not found"));
        if(user.getUserName() != null) {
            existUser.setUserName(user.getUserName());
        }
        return userRepository.save(existUser);
    }

}