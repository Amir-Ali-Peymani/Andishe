package com.example.demo.exception;

public class DataNotFound extends ServiceException{
    public DataNotFound(Long id) {
        super("Data with this "+id+" not found");
    }

}
