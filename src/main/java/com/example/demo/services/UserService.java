package com.example.demo.services;

import com.example.demo.entities.UserP;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

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

    public List<UserP> getUserByEmail(String email){ return userRepository.findByEmail(email); }

    public List<UserP> getUserByUserName(String userName){ return userRepository.findByUserName(userName); }
}
