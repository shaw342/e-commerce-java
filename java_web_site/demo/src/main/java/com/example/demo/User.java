package com.example.demo;

public class User {
    private String name;
    private String password;
    private String email;

    public String getName(String name){
        return name;
    }
    private void setName(String name){
        this.name = name;
    }

    public String getPassword(String password){
        return password;
    }

    private void setPassword(String password){
        this.password = password;
    }

    public String getEmail(String email){
        return email;
    }
    private void setEmail(String email){
        this.email = email;
    }
}
