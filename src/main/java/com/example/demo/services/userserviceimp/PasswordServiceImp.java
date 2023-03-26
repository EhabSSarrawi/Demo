package com.example.demo.services.userserviceimp;

import com.example.demo.services.PasswordService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PasswordServiceImp implements PasswordService {
    @Bean
    private PasswordEncoder passwordEncoder() {
       return new BCryptPasswordEncoder();
    }

    public String hashPassword(String password) {
        return passwordEncoder().encode(password);
    }

}
