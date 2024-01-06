package com.example.musicapp2.service;

import com.example.musicapp2.model.User;

import java.util.List;

public interface UserService{
    List<User> getUsers();
    User getUser(Long id);
    User getByUserName(String username);
    User findByUsernameAndPassword(String username, String password);
    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(Long id);

}
