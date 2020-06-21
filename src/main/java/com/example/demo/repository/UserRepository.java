package com.example.demo.repository;

import com.example.demo.entities.UserP;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserP, Long> {
    public List<UserP> findByEmail(String email);
    public List<UserP> findByUserName(String userName);
}
