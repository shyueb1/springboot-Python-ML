package com.example.demo.repository;

import com.example.demo.entities.UserP;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserP, Long> {
}
