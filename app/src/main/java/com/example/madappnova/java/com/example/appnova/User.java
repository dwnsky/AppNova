package com.example.appnova;

public class User {
    public String name;
    public String email;

    // REQUIRED empty constructor for Firebase
    public User() {}

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
