package com.example.student.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class StudentDto {

    @NotBlank(message = "Name is Required")
    private String name;

    @Email(message = "Email Should be Valid")
    private String email;

    @Min(value=18, message = "Age must be at least 18")
    private int age;

    //Getter & Setter
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }

}
