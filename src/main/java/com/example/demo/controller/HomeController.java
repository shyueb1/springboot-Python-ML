package com.example.demo.controller;

import com.example.demo.exception.InvalidCredentials;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    /* Returns JSON with employee data */
    @RequestMapping(value = "/api/employees", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK) //http status code 200
    @ResponseBody
    public HashMap<String, String> salaries(){
        HashMap<String, String> map = new HashMap<>();
        map.put("shyueb", "100000");
        map.put("john", "50000");
        return map;
    }

    @RequestMapping(value = "/api/protected", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HashMap<String, String> protectedRoute(@RequestBody Map<String,String> allParams){
        //System.out.println(allParams.entrySet()); gives you list of params
        try{
            HashMap<String, String> map = new HashMap<>();
            map.put("shyueb", "100000");
            map.put("john", "50000");
            if(allParams.get("user").equals("shyueb")){
                return map;
            }else{
                throw new InvalidCredentials("Unauthorised User");
            }
        }catch(InvalidCredentials e){
            HashMap<String, String> map = new HashMap<>();
            map.put("error", "unauthorised");
            return map;
        }
    }

//    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
//    @ResponseBody
//    public String onInvalidCredentials(InvalidCredentials exception) {
//        return exception.toString();
//    }



}
