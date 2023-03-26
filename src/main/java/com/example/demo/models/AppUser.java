package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "users")
public class AppUser {

    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column(name="user_name", nullable = false, unique = true)
    private String userName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "user_level", nullable = false)
    private String userLevel;

    public AppUser(String userName, String email, String password, String userLevel) {
       this.userName = userName;
       this.email = email;
       this.password = password;
       this.userLevel = userLevel;
    }
}