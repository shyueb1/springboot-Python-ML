package com.example.demo.services;

import com.example.demo.entities.HealthRecord;
import com.example.demo.repository.HealthRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class HealthRecordService {

    @Autowired
    HealthRecordRepository healthRecordRepository;

    public List<HealthRecord> getAllHealthRecords(){
        List<HealthRecord> allHealthRecords = new ArrayList<>();
        healthRecordRepository.findAll().forEach(allHealthRecords::add);
        return allHealthRecords;
    }

    public List<HealthRecord> getHealthRecordsById(long id){
        List<HealthRecord> allHealthRecords = new ArrayList<>();
        healthRecordRepository.findAllById(Collections.singleton(id)).forEach(allHealthRecords::add);
        return allHealthRecords;
    }

    public HealthRecord getHealthRecordsByUserName(String userName){
        return healthRecordRepository.findByUserName(userName);
    }

    public HealthRecord getHealthRecordByDate(long id, Date date){
        return healthRecordRepository.findByIdAndDate(id, date);
    }

    public void addHealthRecord(HealthRecord healthRecord){ healthRecordRepository.save(healthRecord); }

    public void updateHealthRecord(HealthRecord healthRecord){ healthRecordRepository.save(healthRecord); }

    public void deleteHealthRecord(HealthRecord healthRecord){ healthRecordRepository.delete(healthRecord); }

    public Boolean willBeOver(){ return false; }

    public Boolean willBeUnder(){ return false; }
}
