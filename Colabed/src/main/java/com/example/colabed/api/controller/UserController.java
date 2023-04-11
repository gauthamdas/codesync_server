package com.example.colabed.api.controller;

import com.example.colabed.api.model.User;
import com.example.colabed.api.model.Userrepository;
import com.example.colabed.service.Userservice;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.tomcat.util.json.JSONFilter;
import org.bson.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController
{
    private Userservice userservice;
    @Autowired
    public UserController(Userservice userservice)
    {
        this.userservice=userservice;
    }
    @GetMapping("/user")
    public User getUser(@RequestParam(value="id", required = false) Integer id)
    {
        Optional user=userservice.getUser(id);
        if(user.isPresent())
        {
            return (User) user.get();
        }
        return null;
    }
    @CrossOrigin
    @PostMapping("/login")
    @ResponseStatus(value=HttpStatus.OK)
    public void Loginuser(HttpEntity<String> entity)
    {
        System.out.println(entity.getBody());
    }
    @PostMapping("/user")
    @ResponseStatus(value= HttpStatus.OK)
    public  User createUser(@RequestBody User user)
    {
    System.out.println(user.getUsername());
        return userservice.newUser(user);
    }

}
