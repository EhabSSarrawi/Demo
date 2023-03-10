package com.example.demo.services.userserviceimp;

import com.example.demo.models.User;
import com.example.demo.services.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordServiceImp implements PasswordService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String hashPassword(String password) {
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    public boolean checkPass(User user, String password) {
        String sql = "SELECT password FROM users WHERE user_name = ? ";
        String hashedPassword = jdbcTemplate.queryForObject(sql, new Object[] { user.getUserName() }, String.class);
        return passwordEncoder.matches(password, hashedPassword);
    }
}
