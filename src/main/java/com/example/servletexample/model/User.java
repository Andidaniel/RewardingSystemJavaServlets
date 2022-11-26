package com.example.servletexample.model;


public class User {
    private String email;
    public User() {
    }

    public User(String email, String pass) {
        this.email = email;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                '}';
    }
}