package com.example.demo.controller;

import com.example.demo.entities.UserGoal;
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
        Boolean emailUsed = userService.getUserByEmail(user.getEmail()) == null ? false : true;
        Boolean userNameUsed = userService.getUserByUserName(user.getUserName()) == null ? false : true;
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
    public Map<String, Boolean> updateUser(@RequestBody UserP user){
        Map<String, Boolean> result = new HashMap<>();
        UserP correctCredentials = userService.getUserByUserName(user.getUserName());
        if(correctCredentials != null){
            if(correctCredentials.getPassword().equals(user.getPassword())){
                userService.updateUser(user);
                result.put("updated", true);
            }else{
                result.put("updated", false);
                result.put("userExists", true);
                result.put("passwordValid", false);
            }
        }else{
            result.put("updated", false);
            result.put("userExists", false);
            result.put("passwordValid", false);
        }
        return result;
    }

    @RequestMapping(value="/users", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteUser(@RequestBody UserP user){
        userService.deleteUser(user);
    }

    @RequestMapping(value = "/users/auth", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> authUser(@RequestBody UserP user){
        Map<String, Object> result = new HashMap<>();
        if(userService.getUserByEmail(user.getEmail()) != null){
            UserP correctCredentials = userService.getUserByEmail(user.getEmail());
            if(correctCredentials.getPassword().equals(user.getPassword())){
                result.put("authorised", "true");
                result.put("user", correctCredentials);
            }else {
                result.put("authorised", "false");
                result.put("error", "incorrect password");
            }
        }else{
            result.put("authorised", "false");
            result.put("error", "incorrect email");
        }
        return result;
    }

    @RequestMapping("/users/goal/{id}")
    @ResponseBody
    public UserGoal getUserGoalById(@RequestParam long userGoalId){
        return userService.getUserGoalById(userGoalId);
    }

    @RequestMapping("/users/goal/{userName}")
    @ResponseBody
    public UserGoal getUserGoalByUserName(@RequestParam UserP user){
        return userService.getUserGoalByUser(user);
    }

    @RequestMapping(value = "/users/goal", method = RequestMethod.POST)
    @ResponseBody
    public void addUserGoalById(@RequestBody UserGoal goal){
        userService.addGoal(goal);
    }


    @RequestMapping(value = "/users/goal", method = RequestMethod.PUT)
    @ResponseBody
    public void updateUserGoalById(@RequestBody UserGoal goal){
        userService.addGoal(goal);
    }

    @RequestMapping(value = "/users/goal", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteUserGoalById(@RequestBody UserGoal goal){
        userService.deleteGoal(goal);
    }
}
