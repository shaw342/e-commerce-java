package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;



@Controller
public class Controllers {
    @RequestMapping(path = "/",method = RequestMethod.GET)
    public String helloGf(){
        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    @PostMapping("/register")
    public String register(@RequestBody User user){
        Database.addData(user);
        return "redirect:/";
    }
    
}
