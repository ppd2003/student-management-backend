package com.example.student.exception;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(Long id){
        super("Student Not Found With id;" +id);
    }

}
