package com.example.demo.controller;

import com.example.demo.entities.UserP;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String, Boolean> addUser(@RequestBody UserP user){
        Map<String, Boolean> result = new HashMap<>();
        Boolean emailUsed = userService.getUserByEmail(user.getEmail()).isEmpty() ? false : true;
        Boolean userNameUsed = userService.getUserByUserName(user.getUserName()).isEmpty() ? false : true;
        result.put("email", emailUsed);
        result.put("userName", userNameUsed);
        result.put("created", !emailUsed&&!userNameUsed);
        if(!emailUsed && !userNameUsed){
            userService.addUser(user);
        }
        return result;
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    @ResponseBody
    public void updateUser(@RequestBody UserP user){
        userService.addUser(user);
    }

    @RequestMapping(value = "/users/auth", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> authUser(@RequestBody UserP user){
        Map<String, Object> result = new HashMap<>();
        if(!userService.getUserByEmail(user.getEmail()).isEmpty()){
            UserP correctCredentials = userService.getUserByEmail(user.getEmail()).get(0);
            if(correctCredentials.getPassword().equals(user.getPassword())){
                result.put("authorised", "true");
                result.put("user", correctCredentials);
                return result;
            }else{
                result.put("authorised", "false");
                result.put("error", "incorrect password");
                return result;
            }
        }else{
            result.put("authorised", "false");
            result.put("error", "incorrect email");
            return result;
        }
    }


}
