package com.example.myblog.exception;

public class ServiceException extends RuntimeException{
    public ServiceException(String msg){
        super(msg);
    }
}
