package com.example.demo.controller;

import com.example.demo.services.MLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MLController {

    @Autowired
    MLService mlService;

    @RequestMapping("/ml/prediction/{id}")
    @ResponseBody
    public String getPrediction(@PathVariable long id){
        return mlService.getPrediction(id);
    }

    @RequestMapping("/ml/test")
    @ResponseBody
    public String getTest(){
        return "Test Successful";
    }
}
