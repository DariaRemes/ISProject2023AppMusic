package com.example.musicapp2.service.impl;

import com.example.musicapp2.model.Admin;
import com.example.musicapp2.model.Artist;
import com.example.musicapp2.model.AuthResponse;
import com.example.musicapp2.model.User;
import com.example.musicapp2.service.AdminService;
import com.example.musicapp2.service.ArtistService;
import com.example.musicapp2.service.AuthService;
import com.example.musicapp2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @Autowired
    private ArtistService artistService;
    @Override
    public AuthResponse authenticateUser(String username, String password) {
        // Try to authenticate as Admin
        Admin admin = adminService.findByUsernameAndPassword(username, password);
        if (admin != null) {
            System.out.println(admin.getId());
            return new AuthResponse(admin, "admin");
        }

        // Try to authenticate as User
        User user = userService.findByUsernameAndPassword(username, password);
        if (user != null) {
            return new AuthResponse(admin, "user");
        }

        // Try to authenticate as Artist
        Artist artist = artistService.findByUsernameAndPassword(username, password);
        if (artist != null) {
            return new AuthResponse(admin, "artist");
        }

        return null;
    }
}
