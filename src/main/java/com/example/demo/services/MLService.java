package com.example.demo.services;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class MLService {

    public MLService() {}

    public String getPrediction(String user){
        String prediction = "";
        String s = null;
        try {
            //Call python script with username arg
            Process p = Runtime.getRuntime().exec("python src/main/python/MLPredictor.py "+user);

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            // read the output from the command
            if((s = stdInput.readLine()) != null){
                prediction = s;
            }
            // read any errors from the attempted command
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            return prediction;
        }
    }


}
