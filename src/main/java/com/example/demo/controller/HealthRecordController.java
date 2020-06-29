package com.example.demo.controller;

import com.example.demo.entities.HealthRecord;
import com.example.demo.entities.UserP;
import com.example.demo.services.HealthRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
public class HealthRecordController {

    @Autowired
    HealthRecordService healthRecordService;

    @RequestMapping("/healthrecords")
    @ResponseBody
    public List<HealthRecord> getAllHealthRecords(){
        return healthRecordService.getAllHealthRecords();
    }

//    @RequestMapping("/healthrecords/{id}")
//    @ResponseBody
//    public List<HealthRecord> getAllHealthRecordsById(@PathVariable long id){
//        List<HealthRecord> records = healthRecordService.getHealthRecordsById(id);
//        return records;
//    }

    @RequestMapping("/healthrecords/{id}")
    @ResponseBody
    public List<HealthRecord> getAllHealthRecordsByUserId(@PathVariable long id){
        List<HealthRecord> records = healthRecordService.getHealthRecordsByUser(new UserP(id, "", "", "", "", "", "",0, new Date(System.nanoTime())));
        return records;
    }

    @RequestMapping("/healthrecords/{id}/{date}")
    @ResponseBody
    public HealthRecord getAllHealthRecordsByDate(@PathVariable long id, @PathVariable Date date){
        return healthRecordService.getHealthRecordByDate(id, date);
    }

    @RequestMapping(value = "/healthrecords", method = RequestMethod.POST)
    @ResponseBody
    public void addHealthRecord(@RequestBody HealthRecord healthRecord){
        healthRecordService.addHealthRecord(healthRecord);
    }

    @RequestMapping(value = "/healthrecords", method = RequestMethod.PUT)
    @ResponseBody
    public void updateHealthRecord(@RequestBody HealthRecord healthRecord){
        healthRecordService.updateHealthRecord(healthRecord);
    }

    @RequestMapping(value = "/healthrecords", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteHealthRecord(@RequestBody HealthRecord healthRecord){
        healthRecordService.deleteHealthRecord(healthRecord);
    }
}
