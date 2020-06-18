package com.example.demo.exception;

public class InvalidCredentials extends Exception{
    public InvalidCredentials(String errMsg){
        super(errMsg);
    }
}
