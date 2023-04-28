package com.ust.SpringBootTestDemo.exception;

public class StudentNotFoundException extends RuntimeException{
    private static final long SerialVersionUID=1L;
    public StudentNotFoundException(String message){
        super(message);

    }
}
