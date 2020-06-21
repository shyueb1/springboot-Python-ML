package com.example.demo.repository;

import com.example.demo.entities.UserGoal;
import com.example.demo.entities.UserP;
import org.springframework.data.repository.CrudRepository;

public interface UserGoalRepository extends CrudRepository<UserGoal, Long> {
    public UserGoal findByUser(UserP user);
}
