package com.hirehub.user.microservice.alluser;

public class LoginRequest {
    private String emailId;
    private String password;

    // Getters et Setters
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
