package com.example.musicapp2.model;

public class AuthResponse {
    private Object user;
    private String userType;

    public AuthResponse(Object user, String userType) {
        this.user = user;
        this.userType = userType;
    }
}
