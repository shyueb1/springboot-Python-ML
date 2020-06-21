package com.example.demo.repository;

import com.example.demo.entities.HealthRecord;
import com.example.demo.entities.UserP;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;

public interface HealthRecordRepository extends CrudRepository<HealthRecord, Long> {
    public HealthRecord findByUser(UserP user);
    public HealthRecord findByDate(Date date);
    public HealthRecord findByIdAndDate(long id, Date date);
}
