package com.example.demo.repository;

import com.example.demo.entities.HealthRecord;
import com.example.demo.entities.UserP;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface HealthRecordRepository extends CrudRepository<HealthRecord, Long> {
    public List<HealthRecord> findByUser(UserP user);
    public HealthRecord findByDate(Date date);
    public HealthRecord findByIdAndDate(long id, Date date);
}
