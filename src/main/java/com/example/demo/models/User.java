package com.example.demo.models;



import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column
    private Integer id=null;

    @Column(name="user_name", nullable = false, unique = true)
    private String userName;

    public User(Integer id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}