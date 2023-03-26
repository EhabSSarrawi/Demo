package com.example.demo.services.userserviceimp;

import com.example.demo.models.AppUser;
import com.example.demo.repositories.UsersRepository;
import com.example.demo.services.PasswordService;
import com.example.demo.services.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.*;

@AllArgsConstructor
@Service
public class UserServiceImp implements UsersService {

    private UsersRepository userRepository;

    private PasswordService passwordService;

    public AppUser addUser(AppUser user) {
        user.setPassword(passwordService.hashPassword(user.getPassword()));
        return userRepository.save(user);
    }


    public AppUser findUser(int id) {
        Optional user =  userRepository.findById(id);
        if (user.isEmpty()) {
            throw new NoSuchElementException("not found");
        }
        return userRepository.findById(id).get();
    }
    

    public void deleteUser(String email) {
        Optional<AppUser> userDB = userRepository.findByEmail(email);
        userRepository.deleteById(userDB.get().getId());
    }

    public AppUser updateUser(AppUser appUser, String email) {
        Optional<AppUser> userDB = userRepository.findByEmail(email);
        userDB.get().setPassword(passwordService.hashPassword(appUser.getPassword()));
        userDB.get().setEmail(appUser.getEmail());
        return userRepository.save(userDB.get());
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<AppUser> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("invalid credentials");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.get().getUserLevel()));
        return new User(user.get().getEmail(), user.get().getPassword(), authorities);
    }
}