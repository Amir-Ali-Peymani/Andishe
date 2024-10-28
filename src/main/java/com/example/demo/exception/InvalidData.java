package com.example.demo.exception;

public class InvalidData extends ServiceException{
    public InvalidData(String message) {
        super(message);
    }
}
