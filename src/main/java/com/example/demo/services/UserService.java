package com.example.demo.services;

import com.example.demo.entities.UserGoal;
import com.example.demo.entities.UserP;
import com.example.demo.repository.UserGoalRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserGoalRepository userGoalRepository;

    public List<UserP> getAllUsers(){
        List<UserP> allUsers = new ArrayList<>();
        userRepository.findAll().forEach(allUsers::add);
        return allUsers;
    }

    public UserP getUserById(long id){
        return userRepository.findById(id).orElse(null);
    }

    public void addUser(UserP user){
        userRepository.save(user);
    }

    public void updateUser(UserP user){
        userRepository.save(user);
    }

    public void deleteUser(UserP user){
        userRepository.delete(user);
    }

    public UserP getUserByEmail(String email){
        List<UserP> matchingUsers = userRepository.findByEmail(email);
        if(!matchingUsers.isEmpty()){
            return matchingUsers.get(0);
        }
        return null;
    }

    public UserP getUserByUserName(String userName) {
        List<UserP> matchingUsers = userRepository.findByUserName(userName);
        if (!matchingUsers.isEmpty()) {
            return matchingUsers.get(0);
        }
        return null;
    }

    public UserGoal getUserGoalById(long userGoalId){
        return userGoalRepository.findById(userGoalId).orElse(null);
    }

    public UserGoal getUserGoalByUser(UserP user){
        return userGoalRepository.findByUser(user);
    }

    public void addGoal(UserGoal userGoal){ userGoalRepository.save(userGoal); }

    public void updateGoal(UserGoal userGoal){ userGoalRepository.save(userGoal); }

    public void deleteGoal(UserGoal userGoal){ userGoalRepository.delete(userGoal); }
}
