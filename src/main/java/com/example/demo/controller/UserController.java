package com.example.demo.controller;

import com.example.demo.entities.UserP;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/users")
    @ResponseBody
    public List<UserP> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping("/users/{id}")
    @ResponseBody
    public UserP getUserById(@PathVariable int id){
        if(userService.getUserById(id) != null){
            return userService.getUserById(id);
        }else{
            return null;
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public void addUser(@RequestBody UserP user){
        System.out.println(user.toString());
        userService.addUser(user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    @ResponseBody
    public void updateUser(@RequestBody UserP user){
        userService.addUser(user);
    }
}
