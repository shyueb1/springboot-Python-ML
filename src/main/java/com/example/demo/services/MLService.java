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
            ProcessBuilder pb = new ProcessBuilder("/usr/local/Frameworks/Python.framework/Versions/3.7/bin/python3.7", "src/main/python/MLPredictor.py", user);
            Process process = pb.start();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line = null;
            
            while ( (line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(System.getProperty("line.separator"));
            }
            String result = builder.toString();
            prediction = result;
            BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

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
