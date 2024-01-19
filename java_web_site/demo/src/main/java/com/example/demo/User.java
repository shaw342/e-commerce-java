package com.example.demo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
    private String name;
    private String password;
    private String email;

    public String getName(){
        return name;
    }
    private void setName(String name){
        this.name = name;
    }

    public String getPassword(){
        return password;
    }

    private void setPassword(String password){
        this.password = password;
    }

    public String getEmail(){
        return email;
    }
    private void setEmail(String email){
        this.email = email;
    }
}
