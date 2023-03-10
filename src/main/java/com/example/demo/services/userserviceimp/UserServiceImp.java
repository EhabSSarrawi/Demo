package com.example.demo.services.userserviceimp;

import com.example.demo.models.User;
import com.example.demo.repositories.UsersRepository;
import com.example.demo.services.JwtService;
import com.example.demo.services.PasswordService;
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

    private PasswordService passwordService;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        user.setPassword(passwordService.hashPassword(user.getPassword()));
        return userRepository.save(user);
    }

    public String checkUser(User user, String userName, String password) {
        String name = userRepository.findByUserName(userName).toString();
        boolean check = passwordService.checkPass(user, password);
        if (check && (name != null)) {
            return jwtService.generateJwtToken(user.getId());
        }
        else {
            return null;
        }
    }

    public User findUser(Integer userId) {
        Optional user =  userRepository.findById(userId);
        return (User) user.get();
    }
    
    public List<User> findUserName(String userName){
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