package com.example.demo.repository;

import com.example.demo.entities.UserGoal;
import org.springframework.data.repository.CrudRepository;

public interface UserGoalRepository extends CrudRepository<UserGoal, Long> {
}
