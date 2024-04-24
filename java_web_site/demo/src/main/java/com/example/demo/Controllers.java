package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.bson.json.JsonObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;



@Controller
@RestController
@ResponseStatus
public class Controllers {
    @RequestMapping(path = "/",method = RequestMethod.GET)
    public String hello(){
        return "home";
    }

    @RequestMapping(path = "/api/login", method = RequestMethod.POST)
    public String login(){
        
        return "hello";
    }
    @GetMapping(path = "/user")
    public String getLogin(){
        return "welcom user";
    }

    @RequestMapping(path = "/api/register",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseStatus(HttpStatus.CREATED)
    public void Register(@RequestBody User request){
        System.out.println(request); 
        Database.addCustomers(request);  
    }

    

}
