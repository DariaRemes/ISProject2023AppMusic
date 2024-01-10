package com.example.musicapp2.controller;


import com.example.musicapp2.dto.CreateAccount;
import com.example.musicapp2.dto.FindByUserNameAndPassword;
import com.example.musicapp2.dto.FindByUsername;
import com.example.musicapp2.model.*;
import com.example.musicapp2.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;
    @Autowired
    private ArtistService artistService;

    @Autowired
    private SongService songService;


    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdmin(@PathVariable Long id){
        return new ResponseEntity<Admin>(adminService.getAdmin(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Admin> saveAdmin(@Valid @RequestBody Admin admin){
         return new ResponseEntity<Admin>((Admin) adminService.saveAdmin(admin),HttpStatus.CREATED);
    }
    @PostMapping("/addAdmin")
    public ResponseEntity addAdmin(@RequestBody CreateAccount createAccount){
        Admin admin =  new Admin(createAccount.getUsername(), createAccount.getEmail(), createAccount.getPassword());
        adminService.saveAdmin(admin);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAdmin(@PathVariable Long id){
         adminService.deleteAdmin(id);
         return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/login")
    public ResponseEntity findByUsernameAndPassword(@RequestBody FindByUserNameAndPassword findBy){
        Admin admin = adminService.findByUsernameAndPassword(findBy.getUsername(), findBy.getPassword());
        if(admin != null){
            return new ResponseEntity(admin,HttpStatus.OK);
        }
        else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
//    @GetMapping("/songs")
//    public ResponseEntity<List<Song>> getSongs(){
//        return new ResponseEntity<List<Song>>(songService.getSongs(),HttpStatus.OK);
//    }

//    @GetMapping("/users")
//    public ResponseEntity<List<User>> getUsers(){
//        return new ResponseEntity<List<User>>(userService.getUsers(),HttpStatus.OK);
//    }
//    @GetMapping("/artists")
//    public ResponseEntity<List<Artist>> getArtists(){
//        return new ResponseEntity<List<Artist>>(artistService.getArtists(),HttpStatus.OK);
//    }

//    @PostMapping("/login")
//    public String login(@RequestParam String username, @RequestParam String password, Model model) {
//        if (adminService.findByUsernameAndPassword(username,password).isPresent()) {
//            return "redirect:/admin/admin_dashboard";
//        } else {
//            model.addAttribute("error", "Invalid username or password");
//            return "login";  // Stay on the login page with an error message
//        }
//    }





}
