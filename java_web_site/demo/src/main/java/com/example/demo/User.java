package com.example.demo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
    private String name;
    private char[] password;
    private String email;

    User (String name,String email,char[] password){
        this.name = name;
        this.email = email;
        this.password = password;

    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public char[] getPassword(){
        return password;
    }
    public void setPassword(char[] password){
        this.password= password;
    }
    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
