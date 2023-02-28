package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column
    private Integer id=null;

    @Column(name="user_name", nullable = false, unique = true)
    private String userName;

    public User() {

    }


}