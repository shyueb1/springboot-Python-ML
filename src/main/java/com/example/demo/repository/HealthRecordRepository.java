package com.example.demo.repository;

import com.example.demo.entities.HealthRecord;
import org.springframework.data.repository.CrudRepository;

public interface HealthRecordRepository extends CrudRepository<HealthRecord, Long> {
}
