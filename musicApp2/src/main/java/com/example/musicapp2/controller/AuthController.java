package com.example.musicapp2.controller;

import com.example.musicapp2.dto.FindByUserNameAndPassword;
import com.example.musicapp2.model.AuthResponse;
import com.example.musicapp2.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/login")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping
    public ResponseEntity findByUsernameAndPassword(@RequestBody FindByUserNameAndPassword findBy) {
        AuthResponse authResponse = authService.authenticateUser(findBy.getUsername(), findBy.getPassword());

        if (authResponse != null) {
            return new ResponseEntity(authResponse,HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
