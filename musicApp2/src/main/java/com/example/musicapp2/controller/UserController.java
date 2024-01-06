package com.example.musicapp2.controller;

import com.example.musicapp2.dto.CreateAccount;
import com.example.musicapp2.dto.CreatePlaylist;
import com.example.musicapp2.dto.FindByUsername;
import com.example.musicapp2.model.*;
import com.example.musicapp2.service.PlaylistService;
import com.example.musicapp2.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PlaylistService playlistService;

    @GetMapping
    public ResponseEntity getUsers(){
        return new ResponseEntity(userService.getUsers(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        return new ResponseEntity<User>((User) userService.getUser(id), HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<User> findByUsername(@RequestBody FindByUsername findByUsername){
        return new ResponseEntity<>(userService.getByUserName(findByUsername.getUsername()),HttpStatus.OK);

    }

//    @PostMapping("")
//    public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
//        return new ResponseEntity<User>((User) userService.saveUser(user),HttpStatus.CREATED);
//    }
    @PostMapping("")
    public ResponseEntity addUser(@RequestBody CreateAccount createAccount){
        User user =  new User(createAccount.getUsername(), createAccount.getEmail(), createAccount.getPassword());
        userService.saveUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping("/playlists")
    public ResponseEntity savePlaylist(@RequestParam Long id, @RequestBody CreatePlaylist createPlaylist){
        User user = userService.getUser(id);
        Playlist playlist = new Playlist(createPlaylist.getName());
        playlistService.savePlaylist(playlist);
        user.setId(id);
        user.getPlaylists().add(playlist);
        userService.saveUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
//        user.setId(id);
//        return new ResponseEntity<User>(userService.updateUser(user),HttpStatus.OK);
//    }
    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody CreateAccount createAccount){
        User user = new User(createAccount.getUsername(), createAccount.getEmail(), createAccount.getPassword());
        user.setId(id);
        userService.updateUser(user);
       return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

//    @GetMapping("/login")
//    public String loginPage() {
//        return "user login";
//    }
//
//    @GetMapping("/register")
//    public String registerPage(Model model) {
//        model.addAttribute("user", new User());
//        return "register";
//    }
//
//    @PostMapping("/register")
//    public String registerAbstractUser(@ModelAttribute User user) {
//        userService.saveAbstractUser(user);
//        return "redirect:/user/login";
//    }
//
//    @GetMapping("/logout")
//    public String logoutPage() {
//        return "redirect:/user/login";
//    }
}
