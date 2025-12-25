package com.example.student.dto;

public class LoginRequestDto {

    private String username;
    private String password;

    public Object getPassword() {
        return password;
    }

    public void setPassword(Object password) {
        this.password= password.toString();
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    //getter & setter
}
