package com.example.musicapp2.controller;

import com.example.musicapp2.model.Admin;
import com.example.musicapp2.model.Song;
import com.example.musicapp2.model.User;
import com.example.musicapp2.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        return new ResponseEntity<User>((User) userService.getAbstractUser(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
        return new ResponseEntity<User>((User) userService.saveAbstractUser(user),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        user.setId(id);
        return new ResponseEntity<User>((User) userService.updateAbstractUser(user),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id){
        userService.deleteAbstractUser(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }
}
