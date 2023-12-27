package com.example.musicapp2.controller;

import com.example.musicapp2.model.AbstractUser;
import com.example.musicapp2.model.Admin;
import com.example.musicapp2.model.Song;
import com.example.musicapp2.service.AbstractUserService;
import com.example.musicapp2.service.AdminService;
import com.example.musicapp2.service.SongService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private SongService songService;

    @Autowired
    private AbstractUserService abstractUserService;

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdmin(@PathVariable Long id){
        return new ResponseEntity<Admin>((Admin) adminService.getAbstractUser(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Admin> saveAdmin(@Valid @RequestBody Admin admin){
         return new ResponseEntity<Admin>((Admin) adminService.saveAbstractUser(admin),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAdmin(@PathVariable Long id){
         adminService.deleteAbstractUser(id);
         return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/songs")
    public ResponseEntity<List<Song>> getSongs(){
        return new ResponseEntity<List<Song>>(songService.getSongs(),HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<AbstractUser>> getUsers(){
        return new ResponseEntity<List<AbstractUser>>(abstractUserService.getAbstractUsers(),HttpStatus.OK);
    }




}
