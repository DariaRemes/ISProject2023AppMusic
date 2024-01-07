package com.example.musicapp2.service;

import com.example.musicapp2.model.AuthResponse;

public interface AuthService {
    AuthResponse authenticateUser(String username, String password);
}
